# Set y parámetros de Puertos
set Puertos; 				# Puertos que podrían formar parte de rutas		
param tasa_contenedor {Puertos}; 	# Pago medio por contenedor manejado en el puerto i
param ratio_contenedor {Puertos};	# Ratio de tiempo de carga y descarga de contendores
param tiempo{Puertos};			# Tiempo transcurrido en el puerto i  durante el atraque y la salida
param Q {Puertos };			# Cantidad de TEUs que sale (+) o entra (-) del puerto i de mercado
param Q_valor {Puertos };		# Cantidad de producto en miles de euros que sale o entra del puerto i de exportación/importacion

# Set y parámetros de Barcos
set Barcos;				# Set de tipos posibles de barcos a usar
param capacidad {t in Barcos};		# Capacidad del barco tipo t
param velocidad {t in Barcos};	 	# Velocidad del barco tipo t
param costo_diario {t in Barcos};	# Costo diario por barco del tipo t
param fuel_km {t in Barcos}; 		# Costo por milla navegada por barco del tipo t

# parametros de barcos y puertos
param fuel_puerto {t in Barcos,Puertos};	# Costo del fuel en el puerto i para el  barco tipo t 
param tasa_fija {t in Barcos,Puertos};		# Tasa fija mínima por barco t en puerto i
param tasa_variable {t in Barcos,Puertos};	# Costo diario por barco del tipo t

# Otros parametros
set arcos within (Puertos) cross (Puertos);	# arcos entre puertos representando las conexiones
param perdidas;					# Valor diario de perdidas por TEU almacenado
param temporada;				# Longitud de la temporada en días
param valor_contenedor;				# valor de un contenedor
param distancia {(i,j) in arcos}; 		# distancias entre puertos
param decision{(i,j) in arcos, Barcos};		# Decisión de barco en cada conexión. 1 si el barco t hace la conexión i -> j
param porcentaje;				# porcentaje de retorno por canarias


# Variables
#var decision {(i,j) in arcos, Barcos} binary; 		# variable de decisión de barco en cada conexión. 1 si el barco t hace la conexión
							# i -> j en la ruta m
var X {(i,j) in arcos, t in Barcos} >=0;	# Cantidad de TEUs llenos transportados en el arco (i,j) por trayecto
var Y {(i,j) in arcos, t in Barcos} >=0;	# Cantidad de TEUs vacíos transportados en el arco (i,j) por trayecto
var XV {(i,j) in arcos, t in Barcos} >=0;	# Valor de transportados en el arco (i,j) por trayecto

# Función objetivo
minimize cost:
#shiping costs 
sum {(i,j) in arcos, t in Barcos} (X[i,j,t]/capacidad[t] * (tasa_fija[t,i] + costo_diario[t]*tiempo[i] + fuel_puerto[t,i] + distancia[i,j]*
(costo_diario[t]/velocidad[t]+ fuel_km[t])))+ sum {(i,j) in arcos, t in Barcos} (Y[i,j,t]/capacidad[t] * (tasa_fija[t,i] + costo_diario[t]*tiempo[i] + fuel_puerto[t,i] + distancia[i,j]*(costo_diario[t]/velocidad[t]+ fuel_km[t])))+

sum {(i,j) in arcos, t in Barcos}((tasa_contenedor[i] + tasa_contenedor[j] + tasa_variable[t,i]/ratio_contenedor[i] + tasa_variable[t,j]/ratio_contenedor[j] + costo_diario[t]/ratio_contenedor[i] + costo_diario[t]/ratio_contenedor[j]) * X[i,j,t])+ sum {(i,j) in arcos, t in Barcos}((tasa_contenedor[i] + tasa_contenedor[j] + tasa_variable[t,i]/ratio_contenedor[i] + tasa_variable[t,j]/ratio_contenedor[j] + costo_diario[t]/ratio_contenedor[i] + costo_diario[t]/ratio_contenedor[j]) * Y[i,j,t]) +

# Inventory costs
temporada*perdidas/2 * sum{(i,j) in arcos, t in Barcos } (if X[i,j,t]<=0 then 0 else (1/(X[i,j,t]/capacidad[t]) * XV[i,j,t])) + temporada*perdidas/2 * sum{(i,j) in arcos, t in Barcos } (if Y[i,j,t]<=0 then 0 else (1/(Y[i,j,t]/capacidad[t]) * valor_contenedor*Y[i,j,t])) +

perdidas *sum{(i,j) in arcos, t in Barcos}((XV[i, j,t]+ valor_contenedor * X[i,j,t]) * (tiempo[i] + tiempo[j] + distancia[i,j]/velocidad[t])) + perdidas *sum{(i,j) in arcos, t in Barcos}(valor_contenedor * Y[i,j,t] * (tiempo[i] + tiempo[j] + distancia[i,j]/velocidad[t])) + 

perdidas * sum{(i,j) in arcos,t in Barcos} (if X[i,j,t]<=0 then 0 else((1/X[i,j,t]/capacidad[t])* (XV[i, j,t]+ valor_contenedor * X[i,j,t])*(X[i,j,t]/ratio_contenedor[i] + X[i,j,t]/ratio_contenedor[j]))) + perdidas * sum{(i,j) in arcos,t in Barcos} (if Y[i,j,t]<=0 then 0 else((1/Y[i,j,t]/capacidad[t])* (valor_contenedor * Y[i,j,t])*(Y[i,j,t]/ratio_contenedor[i] + Y[i,j,t]/ratio_contenedor[j])));

subject to

Balance_llenos {i in Puertos}: sum{(i,j) in arcos, t in Barcos} (X[i,j,t] - X[j,i,t]) = Q[i];
Balance_vacios {i in Puertos}: sum{(i,j) in arcos, t in Barcos} (Y[i,j,t] - Y[j,i,t]) = -Q[i];
Balance_valor {i in Puertos}: sum{(i,j) in arcos, t in Barcos} (XV[i,j,t] - XV[j,i,t]) = Q_valor[i];
		# las mercancias de importacion y exportacion se deben cumplir. Si es 0, se tratara de un hub de transito
Logica {(i,j) in arcos, t in Barcos}: XV[i,j,t] <= X[i,j,t]*sum {k in {'Arg','Uru','Bra','EU'}} Q_valor[k]; 
Fijo1{(i,j) in arcos, t in Barcos}: X[i,j,t] <= decision[i,j,t]*sum {k in {'Arg','Uru','Bra','EU'}} Q[k];
Fijo2{(i,j) in arcos, t in Barcos}: Y[i,j,t] <= decision[i,j,t]*sum {k in {'Arg','Uru','Bra','EU'}} Q[k];

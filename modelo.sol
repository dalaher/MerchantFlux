cost = 1890450000

X :=
Arg Bra SA    76930
Bra EU  SA   203889
Can Ang SE        4.9e-11
EU  Ang SA    25338
EU  Cam SA     6563
EU  Mar SA   150177
EU  Sen SA    21811
Uru Bra SA     4726
;

Y :=
Ang Can SE        4.9e-11
Ang EU  SA    25338
Bra Arg SA    76930
Bra Uru SA     4726
Cam EU  SA     6563
EU  Bra SA   203889
Mar EU  SA   150177
Sen EU  SA    21811
;

XV :=
Arg Bra SA    509767
Bra EU  SA   1514890
EU  Ang SA    409399
EU  Cam SA     47824.8
EU  Mar SA    876240
EU  Sen SA    181429
Uru Bra SA     36710.9
;

La frecuencia de las rutas de contenedores llenos es: 
X[i,j,t]/capacidad[t] :=
Arg Bra SA    66.0911
Bra EU  SA   175.162
Can Ang SE     1.16362e-14
EU  Ang SA    21.768
EU  Cam SA     5.63832
EU  Mar SA   129.018
EU  Sen SA    18.738
Uru Bra SA     4.06014
;

La frecuencia de las rutas de contenedores vacíos es:
Y[i,j,t]/capacidad[t] :=
Ang Can SE     1.16362e-14
Ang EU  SA    21.768
Bra Arg SA    66.0911
Bra Uru SA     4.06014
Cam EU  SA     5.63832
EU  Bra SA   175.162
Mar EU  SA   129.018
Sen EU  SA    18.738
;

El costo de navegación para cada ruta es: 
 if sum{t in Barcos} (X[i,j,t] + Y[i,j,t]) == 0 then 0 else (sum{t in 
  Barcos} X[i,j,t]/capacidad[t]*(tasa_fija[t,i] + costo_diario[t]*tiempo[i] + 
  fuel_puerto[t,i] + distancia[i,j]*(costo_diario[t]/velocidad[t] + 
  fuel_km[t])) + sum{t in Barcos} Y[i,j,t]/capacidad[t]*(tasa_fija[t,i] + 
  costo_diario[t]*tiempo[i] + fuel_puerto[t,i] + distancia[i,j]*(
  costo_diario[t]/velocidad[t] + fuel_km[t])) + sum{t in Barcos} (
  tasa_contenedor[i] + tasa_contenedor[j] + tasa_variable[t,i]/
  ratio_contenedor[i] + tasa_variable[t,j]/ratio_contenedor[j] + 
  costo_diario[t]/ratio_contenedor[i] + costo_diario[t]/ratio_contenedor[j])*
  X[i,j,t] + sum{t in Barcos} (tasa_contenedor[i] + tasa_contenedor[j] + 
  tasa_variable[t,i]/ratio_contenedor[i] + tasa_variable[t,j]/
  ratio_contenedor[j] + costo_diario[t]/ratio_contenedor[i] + costo_diario[t]/
  ratio_contenedor[j])*Y[i,j,t])/(sum{t in Barcos} (X[i,j,t] + Y[i,j,t])) :=
Ang Can   160.152
Ang EU    379.542
Arg Bra   146.086
Bra Arg   144.23
Bra EU    358.498
Bra Uru   159.345
Cam EU    354.254
Can Ang   159.252
EU  Ang   376.535
EU  Bra   358.498
EU  Cam   351.247
EU  Mar    76.999
EU  Sen   184.692
Mar EU     80.0059
Sen EU    187.699
Uru Bra   134.972
;

El costo de Inventario para cada ruta es: 
 if sum{t in Barcos} (X[i,j,t] + Y[i,j,t]) == 0 then 0 else (temporada*
  perdidas/2*(sum{t in Barcos} ( if X[i,j,t] == 0 then 0 else 1/(X[i,j,t]/
  capacidad[t])*XV[i,j,t])) + temporada*perdidas/2*(sum{t in Barcos} ( if Y[i,
  j,t] == 0 then 0 else 1/(Y[i,j,t]/capacidad[t])*valor_contenedor*Y[i,j,t]))
   + perdidas*(sum{t in Barcos} (XV[i,j,t] + valor_contenedor*X[i,j,t])*(
  tiempo[i] + tiempo[j] + distancia[i,j]/velocidad[t])) + perdidas*(sum
  {t in Barcos} valor_contenedor*Y[i,j,t]*(tiempo[i] + tiempo[j] + 
  distancia[i,j]/velocidad[t])) + perdidas*(sum{t in Barcos} ( if X[i,j,t]
   == 0 then 0 else 1/X[i,j,t]/capacidad[t]*(XV[i,j,t] + valor_contenedor*X[i,
  j,t])*(X[i,j,t]/ratio_contenedor[i] + X[i,j,t]/ratio_contenedor[j]))) + 
  perdidas*(sum{t in Barcos} ( if Y[i,j,t] == 0 then 0 else 1/Y[i,j,t]/
  capacidad[t]*(valor_contenedor*Y[i,j,t])*(Y[i,j,t]/ratio_contenedor[i] + Y[i
  ,j,t]/ratio_contenedor[j]))))/(sum{t in Barcos} (X[i,j,t] + Y[i,j,t])) :=
Ang Can       3.52886e+18
Ang EU     4030.4
Arg Bra     616.071
Bra Arg    1218.85
Bra EU     2157.38
Bra Uru   10817.7
Cam EU     9248.55
Can Ang    1059.85
EU  Ang    2187.45
EU  Bra    2380.02
EU  Cam    2010.72
EU  Mar      34.0299
EU  Sen     808.319
Mar EU      350.934
Sen EU     2983.18
Uru Bra     587.413
;


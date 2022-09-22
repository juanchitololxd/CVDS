# Laboratorio 5

## PARTE 1. JUGANDO A SER UN CLIENTE HTTP
<br>
3.Para la peticion GET la syntaxis que maneja es:
<p>GET /"El recurso que se quiere traer" "Protocolo a usar"/"Version del protocolo</p>
<p>Host:"URL de la cual se va a buscar el recurso"</p>
GET /sssss/abc.html HTTP/1.0</br>
Host:www.escuelaing.edu.co<br>

![](./assets/Telnet_Escuela.jpeg)

El codigo 301 dice que la peticion que se esta haciendo ya no se encuenta en en el url dado, a continuacion mostramos la tabla resumen de los codigos de estado de HTTP

![](./assets/TablaHTTPStatusCode.png)
![](./assets/HTTPSCCool.png)

4. Luego de hacer el GET a la nueva URL nos devuelve lo siguiente:
![](./assets/Telnet_Httpbinjpeg.jpeg)

5. Luego de usar el comando wc -c y pegar el texto obtenido en la peticion GET no arroja el numero de lineas las cuales dieron 3579.
![](./assets/Comando_cw.jpeg)

La diferencia entre el metodo GET y POST es que el primero de configuró para traer información, mientras que el segundo se hizo para postear o publicar nueva información. Otros Verbos o métodos son: PUT, HEAD, DELETE

6. Usando el comando "curl"
![](./assets/Comando_curl.jpeg)

El parametro "-v" lo que hace es mostrar mas informacion de la peticion que se esta haciendo,para este caso nos muesta al inicio información con una syntaxis similar a la que se uso en telnet en el paso anterior.
![](./assets/Comando_curl-v.jpeg)

El parametro "-i" nos muestra mas informacion extra de la peticion como el tipo de contenido, el numero de lineas, servidor entre otra.
![](./assets/Comando_curl-i.jpeg)

## PARTE 2. HACIENDO UNA APLCIACIÓN WEB DINÁMICA A BAJO NIVEL


3. El puerto TCP/IP de Tomcat está configurado como el 8080

4.
![](./assets/tomcat.png)

5.
![](./assets/p4-5.png)

6.
![](./assets/p4-6.png)

8.
![](./assets/p4-8.png)


10-15
![](./assets/p4-10.png)


Evidencia implementación del post
![](./assets/post.png)

## PARTE III

17. URL: http://localhost:8080/index.html

20. La diferencia es que con el GET funciona y con el POST no. El motivo es que el POST está configurado para postear un body, y lo que hace el form es simplemente enviaR los parametros que tengamos dentro de el a la URL, es por eso  que falla.

Usando GET:
![](./assets/p3-20.png)

Usando POST:
![](./assets/p3-20A.png)

21. Lo que se está viendo es una renderización del codigo html que internamente está generando la clase  Service.java


## PARTE IV

Sobre esta parte todo lo solicitado está a excepción del punto 11 "Para facilitar los intentos del usuario, se agregará una lista de los últimos intentos fallidos realizado". El motivo es que obtuvimos un error cada que intentabamos usar la etiqueta p:read para poder iterar sobre nuestro arreglo de intentos.


10. c No coinciden, esto es porque @SessionScoped resetea las variables por sesión. En este caso basta con recargar el sitio para que se vuelva a instanciar una nueva clase con otro numero random. 

Por otro lado, @ApplicationScoped mantiene los datos de la clase 'vivos' mientras que el navegador no sea cerrado.

10. d Herramientas de desarrollador:
- Ubique el código HTML generado por el servidor
![](./assets/html.png)


- Busque el elemento oculto, que contiene el número generado aleatoriamente
![](./assets/numoculto.png)

- En la sección de estilos, deshabilite el estilo que oculta el elemento para que sea visible.
![](./assets/numdesocultoxd.png)

- Revise qué otros estilos se pueden agregar a los diferentes elementos y qué efecto tienen en la visualización de la página: Se puede agregar cualquier estilo que sea soportado por CSS.

- Revise qué otros cambios se pueden realizar y qué otra información se puede obtener de las herramientas de desarrollador: Se puede editar el html, o atributos que tengan los nodos por ejemplo. Otra información importante es la que se puede observar en "network". Aquí se ve el trafico de peticiones que han tenido relación con la aplicación.

![](./assets/net.png)


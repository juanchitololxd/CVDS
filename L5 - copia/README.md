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

//TODO

6. Usando el comando "curl"
![](./assets/Comando_curl.jpeg)

El parametro "-v" lo que hace es mostrar mas informacion de la peticion que se esta haciendo,para este caso nos muesta al inicio información con una syntaxis similar a la que se uso en telnet en el paso anterior.
![](./assets/Comando_curl-v.jpeg)

El parametro "-i" nos muestra mas informacion extra de la peticion como el tipo de contenido, el numero de lineas, servidor entre otra.
![](./assets/Comando_curl-i.jpeg)

## PARTE 2. HACIENDO UNA APLCIACIÓN WEB DINÁMICA A BAJO NIVEL
// TODO SampleServlet class

![error ](./assets/error%20package.png)


El puerto TCP/IP de Tomcat está configurado como el 8080

![](./assets/tomcat.png)
![](./assets/tomcat2.png)
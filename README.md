
# TP Final Laboratorio de computación 3: PokeDex


#### 🚀 Equipo
- Gaitan Lucas Agustín
- Gularte Julio
- Mendez Agustina


Para ver nuestro diario de trabajo ingrese aquí: [Informe de Trabajo Final PokeDexTPFINALPROGRA3](https://docs.google.com/document/d/1Nss17ORQAbOJ9tjd4l_ZltfiDPKsZaIK0AFzw1rG-xI/edit?usp=sharing)

## Pasos para levantar sistema
Antes de comenzar con la explicación del funcionamiento del programa hay que realizar una serie de pasos para poder levantar el sistema.

- Clonar el sistema: Para ello tienen que realizar un "git clone https://github.com/LucasGaitan/PokeDexTPFINALPROGRA3.git" o ingresar acá [PokeDexTPFINALPROGRA3](https://github.com/LucasGaitan/PokeDexTPFINALPROGRA3.git) y clickear en "Download ZIP"

![tempsnip](https://user-images.githubusercontent.com/85136443/175438457-5d2add7d-e273-4e64-92e7-8903119d3d1b.png)

- Aplicar JavaFX a el proyecto: 

![image](https://user-images.githubusercontent.com/85136443/175461888-ffecd282-ad82-41a2-95c3-1e98547fc08f.png) 

![image](https://user-images.githubusercontent.com/85136443/175461935-43d17e31-d9f7-47a3-9119-a7e6d5d5c090.png)

![image](https://user-images.githubusercontent.com/85136443/175462003-1e3fb358-aafd-4b7f-83ba-3859c36a11c2.png)

Luego de seleccionar lib, aplican los cambios. 

Hay que configurar el compilador para que ejecute bien JavaJX

![image](https://user-images.githubusercontent.com/85136443/175462262-944a3028-f2a6-40bc-8635-9d7e6794b574.png)

Main->"ModifyOptions"->"Add VM options"

![image](https://user-images.githubusercontent.com/85136443/175462534-857f97c8-5a39-419a-b4d7-4e6c44d1d644.png)

![image](https://user-images.githubusercontent.com/85136443/175462506-2591c9e6-9e3e-4727-8965-eb0da4ffa019.png)

En "VM options" ingresar "--module-path "yourPath...\javafx-sdk-18.0.1\lib" --add-modules javafx.controls,javafx.fxml --add-exports javafx.graphics/com.sun.javafx.sg.prism=ALL-UNNAMED"

![image](https://user-images.githubusercontent.com/85136443/175462620-0b317558-b1af-4463-a45d-934189b222a0.png)


## Manual de uso

- Login y registro

Ingresar usuario y contraseña-> Sign Up  para registrarse.

Ingresar usuario y contraseña-> Log In  para iniciar sesión.

![image](https://user-images.githubusercontent.com/85136443/175465874-e0179977-3ffb-4e57-ab50-0c940fe0bb72.png)

- Funciones de usuario

Log Out para cerrar sesión.

![image](https://user-images.githubusercontent.com/85136443/175466510-3f3b7485-a13e-4fcc-b24a-883cfcda40ce.png)

- Ver PokeDex

Permite seleccionar los Pokémon capturados para ver su información. 

Además es posible liberarlos de la PokeDex.

![image](https://user-images.githubusercontent.com/85136443/175468201-162b0781-276d-450f-a7fe-33cf4d588c4b.png)

- Ver Pokémons de Primera Generación | Capturar

Permite seleccionar los Pokémon de la lista para ver su información. 

Además es posible Capturarlos y que se envien a la PokeDex.

![image](https://user-images.githubusercontent.com/85136443/175468669-f2050d06-954a-4ca3-9864-20975dd4a094.png)

- Funciones de administrador

El administrador puede ver una lista con todos los usuarios, agregar uno, o seleccionar uno para poder modificarlo o eliminarlo. 

Además de eso puede seleccionar un usuario y exportar su información a un JSON que se genera en la carpeta del sistema. El JSON esta titulado como "DatosUsuario.json"

![image](https://user-images.githubusercontent.com/85136443/175470158-83978cd8-01bc-4c19-ab70-1454291fa592.png)



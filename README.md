# jjdzr4-mlodzi-wilcy

## Budowanie obrazu w Dockerze
* w konsoli przejdź do folderu, w którym znajduje się Dockerfile
* wpisz `docker build -f Dockerfile -t [name:version] .`, np. `docker build -f Dockerfile -t myfit:v1 .`  
*! pamiętaj o kropce na końcu*
## Uruchomienie kontenera
* wpisz `docker images` aby sprawdzić IMAGE ID naszego obrazu
* wpisz `docker run -p [port użykownika]:[port kontenera] [początek IMAGE ID]`, np. `docker run -p 8000:8080 3d81`  
*! port użytkownika - port zadeklarowany w Dockerfile*  
*! port kontenera - port domyślny w aplikacji / zadeklarowany w application.properties*
## Sprawdzenie działania aplikacji
* wpisz w przeglądarce adres localhost wskazując port użytkownika np. `http://localhost:8000/`

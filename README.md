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
## Usuwanie istniejących obrazów w dockerze
* docker stop $(docker ps -aq)
* docker rm $(docker ps -aq)
## Tworzenie nowego obrazu w Dockerze
* docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=example --rm -d mysql

## Korzystanie z docker-compose
* docker-compose up --build
* docker-compose down
* docker-compose start
* docker-compose stop
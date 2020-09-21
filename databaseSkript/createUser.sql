#OBS!!! dette er optional!
#Dette skriptet kan  kan dere kjøre om dere ikke har en bruker til å logge inn i databasen

#--> kan være greit å endre trym til sitt navn og et eget passord.
CREATE USER 'johan'@'%' IDENTIFIED BY '021000';
#kjør denne etter dere har lagd en database om dere vil at brukeren deres skal ha tlgang til den databasen.
#funker å bruke root bruker også.
GRANT ALL PRIVILEGES ON * TO 'johan'@'%';
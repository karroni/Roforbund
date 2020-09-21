# Norge roforbund nettside og database

## Last ned prosjektet
Når du åpner IntelliJ, vil du få opp en knapp hvor det står `Check out from Version Control` 
eller `Get from Version Control`. Start med å trykke på den. IntelliJ
skal deretter spørre om en url. Der limer du inn:

`https://github.com/JohanSvartdal/Roforbund`


## Hvordan kjøre prosjektet?
#### Oppsett
Det er noen steg som må gjøres for å få nettsiden oppe å gå.
- Start med å åpne Docker
- Kjør `setup.sh` filen
- Kjør `build.sh` filen

> Da skal applikasjonen funke på
> [http://localhost:8080/Skeleton-1.0/](http://localhost:8080/Skeleton-1.0/)

#### Innlogging
Start med å åpne nettsiden:
> [http://localhost:8080/Skeleton-1.0/](http://localhost:8080/Skeleton-1.0/)

Da skal du få beskjed om å fylle inn e-post og passord.

For å logge inn som **utøver**, bruk følgende parametere:

```
E-post=johan@roing.no
Passord=root
```

Dersom du vil logge inn som **trener**, bruk følgende parametere:

```
E-post=torgeir@roing.no
Passord=root
```
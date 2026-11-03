# Classi innestate, enumerazioni, `equals` e `hashCode`

Si vuole modellare una squadra di calcio (`Team`) composta da un insieme di giocatori.
Tutto il codice va scritto all'interno della classe `it.unibo.team.Team`.

## Parte 1: enum innestata

Si osservi l'enumerazione `Role` innestata dentro `Team` e se ne studi l'utilizzo attuale nel codice.

## Parte 2: classe innestata

All'interno di `Team`, si completi la classe innestata pubblica `Player` che modella un giocatore, caratterizzato da nome, numero di maglia e ruolo (`Role`).
La classe deve essere immutabile, deve avere un costruttore `Player(String name, int number, Role role)` ed i relativi getter.

Si completi poi `Team` con:
- un costruttore `Team(String name)` ed il getter `getName()`;
- `boolean addPlayer(Player player)`, che aggiunge un giocatore e restituisce `false` se era già presente;
- `boolean contains(Player player)`;
- `Set<Player> getPlayersByRole(Role role)`, che restituisce i giocatori con il ruolo indicato.

I giocatori vanno memorizzati in un `HashSet`.

Si provi a rispondere alle seguenti domande:
    > `Player` deve essere `static`? Cosa cambierebbe se non lo fosse?

## Parte 3: `equals` e `hashCode`

Due giocatori sono uguali se hanno lo stesso nome e lo stesso numero di maglia, indipendentemente dal ruolo.
Si ridefiniscano `equals` e `hashCode` (ed anche `toString`) in `Player` coerentemente con questa definizione.

Si verifichi la soluzione eseguendo la classe `TestTeam`.

Si provi a rispondere alle seguenti domande:
    > cosa succederebbe ad `addPlayer` se si ridefinisse solo `equals`, ma non `hashCode`?

## Parte 4: classe inner

All'interno di `Team`, si completi la classe inner (non `static`) pubblica `Lineup` che modella la formazione titolare di una partita, e si crei un metodo `Lineup newLineup()` in `Team` che ne restituisce una nuova, vuota.
`Lineup` deve avere i metodi:
- `boolean addStarter(Player player)`, che ritorna false se il giocatore non fa parte della squadra o se la formazione ha già 11 giocatori;
- `boolean isComplete()`, che restituisce `true` se la formazione ha 11 giocatori, di cui esattamente un portiere;
- `Team getTeam()`, che restituisce la squadra a cui la formazione appartiene.

Si provi a rispondere alle seguenti domande:
    > perché `Lineup` non può essere `static`, mentre `Player` sì?

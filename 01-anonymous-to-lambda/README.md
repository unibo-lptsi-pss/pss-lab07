# Classi anonime e lambda

Si osservino la classe `Student` (package `it.unibo.lambdas.model`), che modella uno studente con i crediti (CFU)
acquisiti e la media dei voti, e la classe `SampleStudents` (package `it.unibo.lambdas.test`), che fornisce alcuni
studenti di esempio.
Queste due classi non vanno modificate.

## Parte 1: `Comparator` come classe separata

1. Si implementi la classe `ByFullNameComparator` (package `it.unibo.lambdas.comparators`), che implementa
   `Comparator<Student>` e ordina gli studenti per cognome e, a parità di cognome, per nome.
   Per confrontare due stringhe si usi il metodo `compareTo` di `String`.
2. Si esegua `UseNamedComparator` e si verifichi che tutti i controlli abbiano successo.

## Parte 2: classi anonime

1. In `UseAnonymousClasses` si creino, **tramite classi anonime**, i tre comparatori richiesti dai commenti:
   - per cognome e, a parità di cognome, per nome;
   - per media dei voti decrescente (si usi `Double.compare`);
   - per crediti crescenti e, a parità di crediti, per cognome (si usi `Integer.compare`).
2. Si esegua `UseAnonymousClasses` e si verifichi che tutti i controlli abbiano successo.
3. Si provi a rispondere alle seguenti domande:
   > Dopo aver compilato, si osservi il contenuto di `build/classes/java/main/it/unibo/lambdas/`; quali file `.class` sono stati generati a partire da `UseAnonymousClasses.java`? Perché?

   > Il primo comparatore è identico a `ByFullNameComparator`; quando conviene scrivere una classe separata, e quando una classe anonima?

## Parte 3: lambda

1. In `UseLambdas` si creino gli stessi tre comparatori della parte 2, questa volta **tramite lambda**.
   Si usi una lambda con corpo a espressione (`(a, b) -> ...`) quando basta una sola espressione,
   e una lambda con corpo a blocco (`(a, b) -> { ... return ...; }`) quando servono più istruzioni.
2. Si esegua `UseLambdas` e si verifichi che tutti i controlli abbiano successo.
3. Si provi a rispondere alle seguenti domande:
   > Nelle lambda i parametri non hanno un tipo dichiarato; come fa il compilatore a sapere che sono di tipo `Student`?

   > Perché è possibile scrivere una lambda al posto di una classe anonima che implementa `Comparator`?
   > Sarebbe possibile farlo per un'interfaccia con due metodi astratti?

   > Dopo aver compilato, quali file `.class` sono stati generati a partire da `UseLambdas.java`?
   > Cosa cambia rispetto alla parte 2?

## Parte 4: lambda per un'interfaccia definita da noi

1. Si osservi l'interfaccia `Criterion` (package `it.unibo.lambdas.api`), che modella un criterio per selezionare
   gli studenti.
2. Si implementi il metodo `select` della classe `Students` (package `it.unibo.lambdas.model`), usando un ciclo
   *for-each*. Si legga con attenzione la Javadoc: il metodo restituisce una **nuova** lista e non deve modificare
   quella ricevuta.
3. In `UseCriteria` si creino i quattro criteri richiesti dai commenti: il primo **tramite classe anonima**, gli altri
   **tramite lambda**.
4. Si esegua `UseCriteria` e si verifichi che tutti i controlli abbiano successo.
3. Si provi a rispondere alle seguenti domande:
   > Si rimuova `final` dalla dichiarazione di `minCredits` e si verifichi che il codice compili ancora.
   > Si aggiunga poi l'istruzione `minCredits++;` subito dopo la creazione di `enoughCredits`: cosa succede? Perché?

import entities.User;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		User aldo = new User("Aldo", "Baglio");
		User giovanni = new User("Giovanni", "Storti");
		User giacomo = new User("Giacomo", "Poretti");

		List<User> usersList = new LinkedList<>(); // Nelle parentesi angolari vado ad indicare il tipo di dato che voglio venga salvato nella lista
		// LinkedList<User> usersList = new LinkedList<>();
		// Se a sx dell'uguale metto List (e non LinkedList o ArrayList) sto usando la tecnica dell'UPCASTING
		// Avrò a disposizione solo i metodi comuni a tutte le liste, cioè non potrò usare i metodi specifici di LinkedList o di ArrayList
		// Questa può sembrare una limitazione, ma invece serve per potersi lasciare una "porta aperta" per poter effettuare una sostituzione
		// "indolore" da un ArrayList ad una LinkedList (o viceversa)
		// Posso quindi permettermi di fare delle prove col mio codice, testando se ArrayList è più performante di LinkedList ad esempio (o viceversa)

		System.out.println(" ------------------------------------- ADD ----------------------------------------------------- ");
		System.out.println("La lista ha " + usersList.size() + " elementi");
		usersList.add(aldo);
		usersList.add(giovanni);
		usersList.add(giacomo);
		usersList.add(0, new User("Ajeje", "Brazorf"));
		// oppure usersList.addFirst(new User("Ajeje", "Brazorf"));
		System.out.println("La lista ha " + usersList.size() + " elementi");
		System.out.println(usersList);

		for (User user : usersList) {
			System.out.println(user);
		}

		System.out.println(" ------------------------------------- GET ----------------------------------------------------- ");
		// Permette di ottenere un elemento fornendo l'indice di tale elemento, attenzione a non uscire dai limiti della lista
		User found = usersList.get(0);
		// oppure User found = usersList.getFirst();
		System.out.println(found);
		try {
			User found2 = usersList.get(7); // <-- IndexOutOfBoundsException
			System.out.println(found2);
		} catch (IndexOutOfBoundsException ex) {
			System.err.println("Utente non trovato!");
		}

		System.out.println(" ------------------------------------- INDEX OF ----------------------------------------------------- ");
		// Ci torna l'indice di uno specifico utente della lista
		System.out.println("L'indice di Giacomo è: " + usersList.indexOf(giacomo));

		System.out.println(" ------------------------------------- CONTAINS ----------------------------------------------------- ");
		// Ci restituisce un booleano che indica se un elemento è presente o meno in una lista
		if (usersList.contains(new User("Aldo", "Baglio"))) {
			// .contains utilizza il metodo .equals degli oggetti internamente. Ciò significa che di default
			// vengono comparate le celle di memoria, ma se io facessi un Override di .equals() potrei stabilire
			// un criterio personalizzato di comparazione, ad es. sono uguali se hanno nome uguale e cognome uguale
			System.out.println("Aldo è nella lista");
		} else {
			System.out.println("Aldo non è nella lista");
		}

		System.out.println(" ------------------------------------- REMOVE ----------------------------------------------------- ");
		// Remove rimuove un elemento dalla lista. Ci sono 2 varianti dello stesso metodo, una per rimuovere in base all'indice passato
		// una per rimuovere in base all'oggetto stesso
		usersList.remove(aldo);
		usersList.remove(2);
		usersList.removeFirst();
		usersList.removeLast();
		System.out.println(usersList);

		System.out.println(" ------------------------------------- ADD ALL ----------------------------------------------------- ");
		// AddAll ci permette di aggiungere in una volta sola, una lista di dati. Posso anche convertire un array in lista e passarglielo
		usersList.addAll(List.of(new User[]{aldo, giovanni, giacomo})); // List.of prende l'array e lo converte in lista
		System.out.println(usersList);

		System.out.println(" ------------------------------------- REMOVE ALL ----------------------------------------------------- ");
		// RemoveAll ci permette di rimuovere una lista (o collection) di elementi
		usersList.removeAll(List.of(new User[]{aldo, giovanni}));
		System.out.println(usersList);

		System.out.println(" ------------------------------------- SET ----------------------------------------------------- ");
		// Set serve per rimpiazzare un elemento con un altro dato un indice
		usersList.set(0, new User("Ajeje", "Brazorf"));
		System.out.println(usersList);

		System.out.println(" ------------------------------------- CLEAR ----------------------------------------------------- ");
		// Svuota totalmente la lista
		System.out.println("La lista è vuota? " + usersList.isEmpty());
		usersList.clear();
		System.out.println("La lista è vuota? " + usersList.isEmpty());
		System.out.println("La lista ha " + usersList.size() + " elementi");
		System.out.println(usersList);

		// ******************************************************** COLLECTIONS E TIPI PRIMITIVI *******************************************
		// ArrayList<int> numeri = new ArrayList<>(); // <-- Non posso creare Collections contenenti dati primitivi
		// Posso però utilizzare le cosiddette WRAPPER CLASSES, ovvero le classi che corrispondono ai tipi primitivi. Ogni tipo primitivo ha la sua:
		// int -> Integer
		// double -> Double
		// long -> Long
		// boolean -> Boolean
		ArrayList<Integer> numeri = new ArrayList<>();
		numeri.add(10);
		numeri.add(20);

		// ******************************************************** RIMUOVERE ELMENTI DA LISTE *******************************************
		ArrayList<String> lettere = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f")); // Arrays.asList mi crea una lista "al volo"
		// e quindi mi permette di inizializzare un'altra lista volendo

		System.out.println(lettere);

//		for (String lettera : lettere) {
//			if (lettera.equals("b")) lettere.remove(lettera); // <-- ConcurrentModificationException, cioè non posso rimuovere elementi mentre itero
//		}

		// Per poter rimuovere elementi durante un ciclo posso o usare un Iterator oppure usare removeIf (che vedremo successivamente)
		Iterator<String> iterator = lettere.iterator();
		while (iterator.hasNext()) { // Fino a che ci sono ulteriori elementi, prosegui con il ciclo
			String lettera = iterator.next(); //
			if (lettera.equals("b")) iterator.remove(); // Attenzione che qua non stiamo usando il .remove delle liste ma quello dell'iterator
		}

		System.out.println(lettere);


		// ****************************************************************** SET **********************************************************
		// I SET sono come se fossero delle liste che però NON AMMETTONO DUPLICATI
		// Attenzione però che questo significa che per ogni inserimento, il metodo add() prima di aggiungere dovrà ciclare su tutti gli elementi
		// del Set per controllare che il nuovo elemento non ci sia già
		// Se l'elemento non c'è lo inserisce, se c'è già non lo inserisce e il metodo add() ci ritornerà false

		HashSet<User> usersSet = new HashSet<>();
		// Set<User> usersSet = new HashSet<>(); volendo potrei usare l'upcasting pure coi Set
		// HashSet è il tipo di Set più utilizzato (non mantiene alcun ordinamento). Alternative sono il LinkedHashSet
		// (che mantiene un ordine di inserimento degli elementi) e il
		// TreeSet ma mi ordina gli elementi (alfabetico nel caso di testo, numerico nel caso di numeri, nel caso di oggetti tipo User dovrei definire
		// io un criterio di ordinamento)
		usersSet.add(aldo);
		usersSet.add(giovanni);
		usersSet.add(giacomo);
		usersSet.add(aldo); // Aggiungere un duplicato non è vietato,  Intellij mi segnala la cosa con un warning, ma non ricevo alcun errore o eccezione
		// Il metodo non farà niente (nessun aggiunta) ma mi tornerà false
		System.out.println(usersSet);

		TreeSet<String> alfabeto = new TreeSet<>(); // Attenzione che ordinare gli elementi in ordine alfabetico è un'operazione molto costosa quindi
		// a meno che non sia strettamente necessario, meglio usare altri tipi di Set
		alfabeto.add("z");
		alfabeto.add("q");
		alfabeto.add("b");
		alfabeto.add("f");

		System.out.println(alfabeto);

		// ****************************************************************** MAP **********************************************************
		// Nelle Map ogni elemento è rappresentato da una COPPIA di <CHIAVE, VALORE>. Quando creiamo una Map difatti dovremo specificare sia il tipo
		// di dato della chiave che il tipo di dato del valore
		// Le chiavi devono essere UNICHE quindi non sono ammessi duplicati. I valori invece possono essere anche duplicati
		// Esistono vari tipi di Map tipo HashMap (le più usate, non ci danno garanzie sull'ordine di inserimento), LinkedHashMap (mantengono l'ordine
		// di inserimento), TreeMap (gli elementi saranno ordinati in base all'ordine naturale delle chiavi)

		HashMap<Integer, User> usersMap = new HashMap<>(); // Qua ad esempio sto dichiarando che la mappa avrà le chiavi di tipo intero e i valori di tipo User
		// Ogni elemento sarà fatto tipo:
		// 21321321 - Aldo Baglio
		// 84565645 - Giovanni Storti
		// 21321323 - Giacomo Poretti

		HashMap<String, String> dizionario = new HashMap<>(); // In questo caso invece sia chiave che valore sono stringhe
		// Quindi ogni elemento sarà fatto tipo così:
		// "Albero" - "Definizione della parola Albero"
		// "Barbagianni" - "Definizione della parola Barbagianni"

		System.out.println("------------------------------------------------- AGGIUNTA ELEMENTI ---------------------------------------------");
		usersMap.put(21321321, aldo);
		usersMap.put(84565645, giovanni);
		usersMap.put(21321323, giacomo);
		System.out.println(usersMap);

		dizionario.put("Albero", "Definizione della parola Albero");
		dizionario.put("Barbagianni", "Definizione della parola Barbagianni");
		dizionario.put("Albero", "asoidjioasjdoijsaoidj"); // Non ci possono essere 2 elementi con la stessa chiave,
		// ma se faccio put con la stessa mi sovrascrive il precedente
		System.out.println(dizionario);

		System.out.println("------------------------------------------------- LEGGERE ELEMENTI ---------------------------------------------");
		System.out.println("La definizione di Barbagianni è: " + dizionario.get("Barbagianni")); // Se non viene trovata la chiave, otterrò NULL

		System.out.println("------------------------------------------------- RIMUOVERE ELEMENTI ---------------------------------------------");
		dizionario.remove("Albero"); // Tramite la chiave posso rimuovere un elemento

		System.out.println("------------------------------------------------- MODIFICARE IL VALORE DI UN ELEMENTO ---------------------------------------------");
		dizionario.replace("Barbagianni", "Definizione più aggiornata di Barbagianni"); // Mi torna il valore vecchio se lo trova altrimenti NULL

		System.out.println("------------------------------------------------- OTTENERE L'ELENCO DI TUTTE LE CHIAVI ---------------------------------------------");

		dizionario.put("Albero", "Definizione della parola Albero");
		Set<String> chiaviDizionario = dizionario.keySet();

		for (String chiave : chiaviDizionario) {
			System.out.println("Chiave: " + chiave);
			System.out.println("Valore: " + dizionario.get(chiave));
		}

		System.out.println("------------------------------------------------- OTTENERE L'ELENCO DI TUTTI I VALORI ---------------------------------------------");
		Collection<String> listaValoriDizionario = dizionario.values();
		System.out.println(listaValoriDizionario);

	}
}

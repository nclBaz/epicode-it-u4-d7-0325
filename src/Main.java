import entities.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		User aldo = new User("Aldo", "Baglio");
		User giovanni = new User("Giovanni", "Storti");
		User giacomo = new User("Giacomo", "Poretti");

		ArrayList<User> usersList = new ArrayList<>(); // Nelle parentesi angolari vado ad indicare il tipo di dato che voglio venga salvato nella lista

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
		// ArrayList<int> numeri = new ArrayList<>(); // <-- Non posso creare Collections contenenti dati primitiv
		// Posso però utilizzare le cosiddette WRAPPER CLASSES, ovvero le classi che corrispondono ai tipi primitivi. Ogni tipo primitivo ha la sua:
		// int -> Integer
		// double -> Double
		// long -> Long
		// boolean -> Boolean
		ArrayList<Integer> numeri = new ArrayList<>();
		numeri.add(10);
		numeri.add(20);
	}
}

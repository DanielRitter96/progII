public class Main{
	public static void main(String[] args){
		ISortable[] array={
			new Bluray("Resi X", 25, "Capcom", "BOZ556T"),
			new CD("Slap me", "MC Cool", "Music Network", 13, "HLAT886"),
			new Book("Das Geheimnis des Sigels", "F.R.ancine", "Best Bookz", 18, "51825946H"),
			new CD("drop it", "yankee!", "Music Network", 7, "GVPADO765"),
			new Bluray("Brocoli- Das making of", 32, "schlechte Dokus ev", "BKDIDO567"),
			new CD("Parrtiey", "MC Cool", "Music Network", 10, "HZAT815"),
			new Book("Was tun wenn einem nichts mehr einfällt", "Mr. nobody", "Selbsthilfe und co kg", 27, "535863898-H"),
			new Bluray("Was tun wenn einem nichts mehr einfällt- Der Film", 22, "schlechte Dokus ev", "BKFOA87"),
			new CD("MUSIC", "the broszers", "Eigen release", 5, "laidsf55"),
			new Book("Die Schlucht", "Kevin Greys", "Krimi Home", 27, "897168798-T"),
		};
		System.out.println(array);
		Sort.sort(ID, array);
		System.out.println(array);
		
	}
}
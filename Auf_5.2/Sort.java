public class Sort{
	public static void sort(SortMode mode, ISortable[] toSort){
		
			for(int i= 0; i < toSort.length - 1; i++){
				for(int j= i + 1; j < toSort.length; j++){
					if(toSort[i].getSortString(mode).compareTo(toSort[j].getSortString(mode)) > 0){
						ISortable temp= toSort[i];
						toSort[i]= toSort[j];
						toSort[j]= temp;
					}
				}
			}
		}
	}
}
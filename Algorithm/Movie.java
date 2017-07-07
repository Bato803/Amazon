public class MovieFind {


	private class Movie {

		private int id;
		private int rate;
		private List<Movie> movieList;

		public Movie(int id, int rate, List<Movie> movieList) {
			this.id = id;
			this.rate = rate;
			this.movieList = movieList;
		}


	}

	private List<Movie> find(Movie movie, int k) {

		Queue<Movie> q = new LinkedList<>();

		PriorityQueue<Movie> priorityQueue = new PriorityQueue<>(new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				return o2.rate - o1.rate;
			}
		});

		Set<Integer> set = new HashSet<>();

		q.add(movie);
		set.add(movie.id);

		while (!q.isEmpty()) {

			Movie temp = q.poll();

			for (Movie aMovie : temp.movieList) {
				if (!set.contains(aMovie.id)) {
					set.add(aMovie.id);
					q.add(aMovie);

					if (priorityQueue.size() > k) {
						priorityQueue.poll();
					}

					priorityQueue.add(aMovie);

				}


			}
		}

		List<Movie> res = new ArrayList<>();
		while (!priorityQueue.isEmpty()) {
			res.add(priorityQueue.poll());
		}

		return res;
	}


}

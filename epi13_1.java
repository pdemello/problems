import java.util.*;

public class epi13_1 {
	public static class Pair {
		int x;
		int y;
	}
	public static void main(String[] args) {
		// populate maze
		final byte[][] maze = {	{	0, 1, 1, 1, 1, 1, 0, 0, 1, 1	},
								{	1, 1, 0, 1, 1, 1, 1, 1, 1, 1	},
								{	0, 1, 0, 1, 1, 0, 0, 1, 0, 0	},
								{	1, 1, 1, 0, 0, 0, 1, 1, 0, 1	},
								{	1, 0, 0, 1, 1, 1, 1, 1, 1, 1	},
								{	1, 0, 0, 1, 1, 0, 1, 0, 0, 1	},
								{	1, 1, 1, 1, 0, 1, 1, 1, 1, 1	},
								{	0, 1, 0, 1, 0, 1, 0, 1, 1, 1	},
								{	0, 1, 0, 0, 1, 1, 1, 0, 0, 0	},
								{	1, 1, 1, 1, 1, 1, 1, 0, 0, 1	}	};
        final int startx = 0, starty = 9, endx = 9, endy = 0;

        byte[][] baze = 		{ {	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0	},
								{   0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0    },
                                {   0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0    },
                                {   0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0    },
                                {   0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0    },
                                {   0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0    },
                                {   0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0    },
                                {   0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0    },
                                {   0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0    },
                                {   0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0    },
                                {   0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0    },
								{	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0	}};
		final int bstartx = 1, bstarty = 10, bendx = 10, bendy = 1;
		Deque<Pair> s = new ArrayDeque<Pair>();
		s.push(new Pair(){{x = bstartx; y = bstarty;}});
		boolean ret = false;
		while (s.size() > 0) {
			// is this the end?
			
			baze[p.x][p.y] = 0;
		}


	}
}

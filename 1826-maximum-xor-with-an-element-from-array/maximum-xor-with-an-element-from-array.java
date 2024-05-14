class Solution {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
		pair []p = new pair[queries.length];
		
		for(int i=0;i<p.length;i++) {
			p[i] = new pair(queries[i][0], queries[i][1],i);
		}

		Arrays.sort(p, new Comparator<pair>(){
			public int compare(pair o1, pair o2) {
				return o1.mi-o2.mi;
			}
		});
		
		int [] ans = new int[p.length];
		int j=0;
		Node root = new Node();
		for(pair x:p) {
			while(j<nums.length && nums[j]<=x.mi) {
				Insert(root,nums[j]);
				j++;
			}
			if(j==0)
				ans[x.i]=-1;
			else
					ans[x.i]=getxor(root,x.xi);
		}
        return ans;
    }
    public static class Node {
		Node zero;
		Node one;
	}
	
	static class pair{
		int xi,mi,i;
		public pair(int xi, int mi,int i) {
			this.xi = xi;
			this.mi = mi;
			this.i = i;
		}
	}

	public static void Insert(Node root, int val) {
		Node curr = root;
		for (int i = 31; i >= 0; i--) {
			int bit = (val & (1 << i));
			if (bit == 0) {
				if (curr.zero != null) {
					curr = curr.zero;
				} else {
					Node nn = new Node();
					curr.zero = nn;
					curr = nn;
				}
			} else {
				if (curr.one != null) {
					curr = curr.one;
				} else {
					Node nn = new Node();
					curr.one = nn;
					curr = nn;

				}
			}
		}
	}

    private static int getxor(Node root, int val) {
		// TODO Auto-generated method stub
		Node curr = root;
		int xor = 0;
		for (int i = 31; i >= 0; i--) {
			int bit = (val & (1 << i));
			if (bit == 0) {
				if (curr.one != null) {
					xor += (1 << i);
					curr = curr.one;
				} else {
					curr = curr.zero;
				}
			} else {
				if (curr.zero != null) {
					xor += (1 << i);
					curr = curr.zero;
				} else {
					curr = curr.one;
				}
			}
		}
		return xor;
	}

}
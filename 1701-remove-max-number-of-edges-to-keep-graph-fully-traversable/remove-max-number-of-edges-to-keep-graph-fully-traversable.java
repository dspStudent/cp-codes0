class DisjointUnionSet {
	int dsu[];
	int rank[];
	int size[];
	DisjointUnionSet(int n) {
		dsu = new int[n];
		rank = new int[n];
		size = new int[n];
		Arrays.fill(size, 1);
		for (int i = 0; i < n; i++)dsu[i] = i;
	}
	public int ultPar(int x) {
		if (x == dsu[x])return x;
		return dsu[x] = ultPar(dsu[x]);
	}
	public void addEdegeBySize(int x, int y) {
		int parX = ultPar(x);
		int parY = ultPar(y);
		if (parX == parY)return;
		if (size[parY] > size[parX]) {
			dsu[parX] = parY;
			size[parY]+=size[parX];
			return ;
		}
		dsu[parY] = parX;
		size[parX]+=size[parY];
	}
}
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointUnionSet dsu1 = new DisjointUnionSet(n + 1);
        DisjointUnionSet dsu2 = new DisjointUnionSet(n + 1);
        int count = 0;
        
        // Process type 3 edges first
        for (int[] ed : edges) {
            int type = ed[0], x = ed[1], y = ed[2];
            if (type == 3) {
                if (dsu1.ultPar(x) == dsu1.ultPar(y) && dsu2.ultPar(x) == dsu2.ultPar(y)) {
                    count++;
                } else {
                    dsu1.addEdegeBySize(x, y);
                    dsu2.addEdegeBySize(x, y);
                }
            }
        }
        
        // Process type 1 and type 2 edges
        for (int[] ed : edges) {
            int type = ed[0], x = ed[1], y = ed[2];
            if (type == 1) {
                if (dsu1.ultPar(x) == dsu1.ultPar(y)) {
                    count++;
                } else {
                    dsu1.addEdegeBySize(x, y);
                }
            } else if (type == 2) {
                if (dsu2.ultPar(x) == dsu2.ultPar(y)) {
                    count++;
                } else {
                    dsu2.addEdegeBySize(x, y);
                }
            }
        }
        
        // Check if all nodes in dsu1 are connected
        int par1 = dsu1.ultPar(dsu1.dsu[1]);
        for (int i = 1; i <= n; i++) {
            if (par1 != dsu1.ultPar(dsu1.dsu[i])) {
                return -1;
            }
        }
        
        // Check if all nodes in dsu2 are connected
        int par2 = dsu2.ultPar(dsu2.dsu[1]);
        for (int i = 1; i <= n; i++) {
            if (par2 != dsu2.ultPar(dsu2.dsu[i])) {
                return -1;
            }
        }
        
        return count;
    }
}


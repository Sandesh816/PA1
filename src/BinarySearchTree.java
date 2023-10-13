import java.util.ArrayList;


public class BinarySearchTree<P extends Comparable<P> & getP> {

    private BSTreeNode<P> root;
	
    public void add(P p) {

	if (root == null) {
	    root = new BSTreeNode<P>(p);
	    root.parent = null;
	}
	else root.add(p);
    }
	
    public int count() {
	if (root == null) {
	    return 0;
	}
	else return root.count();
    }

    public void setRoot(BSTreeNode<P> r) {
	root = r;
    }

    public BSTreeNode<P> getRoot() {
	return root;
    }

    public void printMe() {
	if (root == null) {
	    System.out.println("Empty tree");
	}
	else root.printMe();
    }

	public BSTreeNode<P> smallest(){
		if (root == null) {
			System.out.println("Empty tree");
			return null;
		}
		else {
			return root.smallest();
		}
	}

	public int countLeaves(){
		if (root == null){
			System.out.println("Empty tree");
			return 0;
		}
		else {
			return root.countLeaves();
		}
	}

	public int height(){
		if (root == null){
			System.out.println("Empty tree");
			return 0;
		}
		else {
			return root.height();
		}
	}

	public boolean inBalance(int limit){
		if (root == null){
			System.out.println("Empty tree");
			return true;
		}
		else {
			return root.inBalance(limit);
		}
	}

	public void truncate(int limit){
		if (root == null){
			System.out.println("Empty tree");
		}
		// subtracting the root value from the previous limit for new limit
		else {
			root.truncate(limit-root.p.getP());
		}
	}

	public int countG(P newP){
		if (root == null){
			System.out.println("Empty tree");
			return 0;
		}
		else {
			return root.countG(newP);
		}
	}

	public void getNodesInOrder(ArrayList<BSTreeNode<P>> a){
		if (root==null){
			System.out.println("Empty tree");
		}
		else {
			root.getNodesInOrder(a);
		}
	}

	public void delete(P newP){
		if (root==null){
			System.out.println("Empty tree");
		}
		else {
			root.delete(newP);
		}
	}
}


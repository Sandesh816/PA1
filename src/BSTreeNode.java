import java.util.ArrayList;

public class BSTreeNode<P extends Comparable<P> & getP> {

	P p;

	BSTreeNode<P> right, left, parent;

	public BSTreeNode(P p){
		this.p = p;
	}


	public BSTreeNode<P> add(P newP) {
		// we found it - don't add it
		int compare = p.compareTo(newP);
		if (compare == 0)
			return this;
		// if the new element is larger
		else if (compare < 0) {
			if (right == null) {
				right = new BSTreeNode<P>(newP);
				right.parent = this;
				return right;
			}
			else {
				return right.add(newP);
			}
		}
		// if the element is smaller
		else {
			if (left == null) {
				left = new BSTreeNode<P>(newP);
				left.parent = this;
				return left;
			}
			else {
				return left.add(newP);
			}
		}
	}


	public int count() {
		int ret = 1;

		if (right != null)
			ret = ret + right.count();
		if (left != null)
			ret = ret + left.count();

		return ret;
	}

	public void printMe() {
		System.out.println(p.getP());
		if (left != null)
			left.printMe();
		if (right != null)
			right.printMe();

	}
	public BSTreeNode<P> smallest(){
		// when you get to the leftmost end
		if (left==null){
			return this;
		}
		// when there are still elements in the left
		else {
			return left.smallest();
		}
	}

	public int countLeaves(){
		// if a leaf is found
		if (left==null && right == null){
			return 1;
		}
		// if elements are present in only left
		else if (left!=null && right == null){
			return left.countLeaves();
		}
		// if elements are present in only right
		else if (left == null && right!=null){
			return right.countLeaves();
		}
		// if elements are present in both left and right
		else {
			return left.countLeaves()+ right.countLeaves();
		}
	}


	public int height(){
		// in case of just the root or when we reach a leaf node
		if (left==null && right == null){
			return 0;
		}
		// if elements are present in only left
		else if (left!=null && right==null){
			return 1+left.height();
		}
		// if elements are present in only right
		else if (left==null && right!=null){
			return 1+right.height();
		}
		// if elements are present in both left and right
		else{
			return 1+Math.max(left.height(), right.height());
		}
	}

	public boolean inBalance(int limit){
		// in case of elements present in both left and right
		if (left!=null && right != null){
			if (Math.abs(left.height() - right.height())>limit){
				return false;
			}
			else {
				return left.inBalance(limit) && right.inBalance(limit);
			}
		}
		// in case of elements present in only left
		else if (left!=null && right==null){
			return left.inBalance(limit);
		}
		// in case of elements present in only right
		else if (left==null && right!=null){
			return right.inBalance(limit);
		}
		// when we reach a leaf node
		else {
			return true;
		}
	}

	public void truncate(int limit){
		// if left has children, perform truncate in left with a new limit
		if (left!=null){
			if (left.p.getP()<=limit){
				left.truncate(limit-left.p.getP());
			}
			else {
				left=null;
			}
		}
		// if right has children, perform truncate in right with a new limit
		if (right!=null){
			if (right.p.getP()<=limit){
				right.truncate(limit-right.p.getP());
			}
			else {
				right=null;
			}
		}
	}

	public int countG(P newP){
		// if the newP is smaller than p, add the node and all the nodes to its right
		if (p.compareTo(newP)>0){
			if (right!=null){
				return 1+right.count()+left.countG(newP);
			}
			else {
				return 1+left.countG(newP);
			}
		}
		// if the newP is greater than p, perform countG on its right child
		else if (p.compareTo(newP)<0){
			return right.countG(newP);
		}
		// when we find the newP
		else{
			if (right!=null){
				return right.count();
			}
			else {
				return 0;
			}
		}
	}

	public void getNodesInOrder(ArrayList<BSTreeNode<P>> a){
		// I IMPLEMENTED THE SAME ORDER AS YOU HAVE IN THE PRINTME METHOD
		// first get this value
		a.add((BSTreeNode<P>) this);
		// then get the smaller values
		if (left!=null){
			left.getNodesInOrder(a);
		}
		// then get larger values
		if (right!=null){
			right.getNodesInOrder(a);
		}

		// HERE IS A DIFFERENT ORDER
//		 // first get the smaller values
//		if (left!=null){
//			left.getNodesInOrder(a);
//		}
//		// then get this value
//		a.add((BSTreeNode<Person>) p);
//		// then get larger values
//		if (right!=null){
//			right.getNodesInOrder(a);
//		}
	}

	public void delete(P newP){
		// if the new node is greater, go right to find the node
		if (p.compareTo(newP)<0){
			right.delete(newP);
		}
		// if the new node is smaller, go left to find the node
		else if (p.compareTo(newP)>0){
			left.delete(newP);
		}
		// when we find the node
		else{
			// if it's a root
			if (parent==null){
				if (right!=null){
					BSTreeNode<P> tmp = right.smallest();
					P temporary = tmp.p;
					tmp.delete(temporary);
					this.p = temporary;
				}
				else if (left!=null){
					this.p = left.p;
					left = left.left;
					right = left.right;
				}
				else {
					this.p = null;
				}
			}
			else {
				// if it's a leaf
				if (left==null && right==null){
					// if it's a left child
					if (parent.p.compareTo(this.p)>0){
						parent.left = null;
					}
					else {
						parent.right = null;
					}
				}
				// if it has a right child
				else if (right!=null){
					BSTreeNode<P> tmp = right.smallest();
					P temporary = tmp.p;
					tmp.delete(temporary);
					this.p = temporary;
				}
				else {
					// if it's a left child
					if (parent.p.compareTo(this.p) > 0) {
						parent.left = left;
					} else {
						parent.right = left;
					}
				}
			}
			}
		}
	}


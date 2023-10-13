import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String a = "aaaaa";
        String b = "bbbbb";
        String c = "a";
        String d = "b";
        Person A = new Person(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b, a);
        Person B = new Person(b+b+b+b+b+b+b+b+b, a);
        Person C = new Person(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b, a);
        Person D = new Person(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b, a);
        Person E = new Person(b+b+b+b+b+b+b, a);
        Person F = new Person(b+b+b+b+b, a);
        Person G = new Person(b+b+b+b+b+b+b+b+b+b+b+b+b, a);
        Person H = new Person(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b, a);
        Person I = new Person(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b, a);
        Person J = new Person(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b, a);
        Person K = new Person(b, a);
        Person L = new Person(b, a);
        Person M = new Person(d,c);
        BinarySearchTree<Person> tree = new BinarySearchTree<>();
        tree.add(A);
        tree.add(B);
        tree.add(C);
        tree.add(D);
        tree.add(E);
        tree.add(F);
        tree.add(G);
        tree.add(H);
        tree.add(I);
        tree.add(J);
        tree.add(K);
        tree.add(L);
        tree.add(M);
//        System.out.println();
//        System.out.println(tree.count());
//        System.out.println();
//        System.out.println();
//
//        tree.printMe();
//        System.out.println();
//        System.out.println();
//        System.out.println(tree.countLeaves());
//        System.out.println(tree.height());
//        System.out.println(tree.smallest().p.getP());
////        tree.truncate(300);
////        System.out.println(tree.count());
////        tree.printMe();
//        System.out.println(tree.countG(G));
//        System.out.println(tree.countG(H));
//        System.out.println(tree.countG(L));
//        System.out.println(tree.countG(B));
//        System.out.println(tree.countG(G));
//        ArrayList<BSTreeNode<Person>> list = new ArrayList<>();
//        tree.getNodesInOrder(list);
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        for (int i=0; i<list.size(); i++){
//            System.out.println(list.get(i).p.getP());
//        }
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        tree.printMe();
//        System.out.println();
//        System.out.println();
//        tree.delete(B);
//        tree.printMe();
//        System.out.println();
//        tree.delete(C);
//        tree.printMe();
//        System.out.println();
//        tree.delete(A);
        tree.printMe();
        System.out.println(tree.inBalance(1));




    }
}
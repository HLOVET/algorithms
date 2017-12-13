package DataStructrue;

//AVL树(平衡二叉搜索树)，插入新的元素节点后通过旋转实现自平衡(根节点左右子树深度差只能为-1、0、1)，暂时只实现了insert方法
public class AVLTree<AnyType extends Comparable<? super AnyType>>{
	private AvlNode<AnyType> root;//该树当前根节点
	//节点数据类
	private static class AvlNode<AnyType>{
		AnyType element;
		AvlNode<AnyType> left;
		AvlNode<AnyType> right;
		int height;
		public AvlNode(AnyType ele) {
			this(ele, null, null);
		}
		public AvlNode(AnyType ele,AvlNode<AnyType> lt,AvlNode<AnyType> rt) {
			this.element=ele;
			left=lt;
			right=rt;
			height=0;
		}
	}
	//对insert方法的封装
	public void inSert(AnyType ele){
		root = inSert(ele, root);
	}
	//以node为根节点insert元素
	private AvlNode<AnyType> inSert(AnyType x,AvlNode<AnyType> node){
		if(node==null){
			return new AvlNode<AnyType>(x);//递归最终新建一个节点返回
		}
		int comparRes = x.compareTo(node.element);
		//大于当前结点，插入右子树
		if(comparRes>0){
			node.right=inSert(x, node.right);
			//需要自平衡
			if(getHeight(node.right)-getHeight(node.left)==2){
				//插入的节点位置为子树的右子树造成不平衡
				if(x.compareTo(node.right.element)>0){
					//左旋操作
					node = leftRotate(node);
				}else{
					//先左旋后右旋操作(插入位置为子树的左子树造成不平衡)
					node = doubleLeftRo(node);
				}
			}
		}else if(comparRes<0){	//小于当前结点，插入左子树
			node.left=inSert(x, node.left);
			if(getHeight(node.left)-getHeight(node.right)==2){
				if(x.compareTo(node.left.element)<0){
					//右旋
					node = rightRotate(node);
				}else{
					//先右后左
					node = doubleRightRo(node);
				}
			}
		}
		//更新节点深度
		node.height=Math.max(getHeight(node.left), getHeight(node.right))+1;
		return node;//返回平衡后的root结点
	}
	
	private int getHeight(AvlNode<AnyType> node){
		//空节点为-1，后续处理中会+1操作，即新建节点深度刚好为0
		return node==null?-1:node.height;
	}
	//左旋
	private AvlNode<AnyType> leftRotate(AvlNode<AnyType> k2){
		AvlNode<AnyType> k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		k2.height = Math.max(getHeight(k2.left), getHeight(k2.right))+1;
		k1.height = Math.max(getHeight(k1.right), k2.height)+1;
		return k1;
	}
	//右旋
	private AvlNode<AnyType> rightRotate(AvlNode<AnyType> k2){
		AvlNode<AnyType> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(getHeight(k2.left), getHeight(k2.right))+1;
		k1.height = Math.max(getHeight(k1.right), k2.height)+1;
		return k1;
	}
	
	//先左旋后右旋
	private AvlNode<AnyType> doubleLeftRo(AvlNode<AnyType> k){
		k.right = leftRotate(k.right);
		return rightRotate(k);
	}
	//先右旋后左旋
	private AvlNode<AnyType> doubleRightRo(AvlNode<AnyType> k){
		k.left = rightRotate(k.left);
		return leftRotate(k);
	}
	
	//
	public void printTree(){
		if(root==null){
			System.out.println("empty tree");
		}else{
			printTree(root);
		}
	}
	//输出
	private void printTree(AvlNode<AnyType> node) {
		if(node!=null){
			printTree(node.left);
			System.out.print(node.element+" ");
			printTree(node.right);
		}
	}
	
	public static void main(String[] args) {
		AVLTree<Integer> atree = new AVLTree<Integer>();
		atree.inSert(4);
		atree.inSert(7);
		atree.inSert(0);
		atree.inSert(1);
		atree.inSert(6);
		atree.inSert(12);
		atree.printTree();
	}
	
	
	
}

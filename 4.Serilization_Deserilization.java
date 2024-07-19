import java.util.LinkedList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp_node = q.poll();
            if(temp_node==null){
                res.append("#").append(" ");
                continue;
            }
            res.append(temp_node.val).append(" ");
            q.add(temp_node.left);
            q.add(temp_node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] data_arr = data.split(" ");
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(data_arr[0]));
        q.add(root);
        for(int i=1;i<data_arr.length;i++){
            TreeNode temp_node = q.poll();
            if(!data_arr[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(data_arr[i]));
                temp_node.left=left;
                q.add(left);
            }
            if(!data_arr[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(data_arr[i]));
                temp_node.right=right;
                q.add(right);
            }
        }
        return root;
    }
    void printBFS(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.val + " ");

            // Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            // Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
class Serilization_Deserilization {
    public static void main(String[] args) {
        Codec obj = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        String tostring = obj.serialize(root);
        System.out.println(tostring);
        obj.printBFS(root);
    }
}

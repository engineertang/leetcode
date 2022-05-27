# 二叉树

## 遍历二叉树

### 1.前序
* <b>通过递归recursion的方式</b>
```java
        list.add(root.val);
        list.addAll(recursion(root.left));
        list.addAll(recursion(root.right));
```
* <b>通过迭代iteration的方式</b>

使用栈，先添加右子节点，再添加左子节点
```java
        TreeNode tmp = stack.pop();
        result.add(tmp.val);
        stack.push(tmp.right);
        stack.push(tmp.left);
```
### 2.中序
* <b>通过递归recursion的方式</b>
```java
    public List<Integer> recursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.addAll(recursion(root.left));
            list.add(root.val);
            list.addAll(recursion(root.right));
        }
        return list;
    }
```
* <b>通过迭代iteration的方式</b>

先迭代根节点，将它的所有子节点都添加在栈中
```java
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (stack.size() != 0) {
            TreeNode tmp = stack.pop();
            result.add(tmp.val);
```

### 3.后序 左右中
* <b>通过递归recursion的方式</b>
```java
        list.addAll(recursion(root.left));
        list.addAll(recursion(root.right));
        list.add(root.val);
```
* <b>使用Stack栈，通过迭代iteration的方式</b>

前序是中左右，略作改动，改为中右左，然后将结果reversed,变成左右中
使用栈，先添加右子节点，再添加左子节点
```java
        TreeNode tmp = stack.pop();
        result.add(tmp.val);
        stack.push(tmp.left);
        stack.push(tmp.right);
        
        reverse(result);// 反转
```

### 4.层序
* <b>使用Queue队列，通过迭代iteration的方式</b>
```java
        while (!queue.isEmpty()) {
            // queue里只会保留当前一层的节点
            int levelCount = queue.size();
            LinkedList<Integer> list = new LinkedList();

            while(levelCount > 0){
                TreeNode current = queue.remove();
                list.add(current.val);

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }

                levelCount --;
            }

            result.add(list);
        }
```
##
## 递归二叉树
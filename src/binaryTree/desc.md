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
        TreeNode tmp = stackAndDFS.pop();
        result.add(tmp.val);
        stackAndDFS.push(tmp.right);
        stackAndDFS.push(tmp.left);
```
### 2.中序
* <b>通过递归recursion的方式，采用深度优先算法</b>
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
            stackAndDFS.push(cur);
            cur = cur.left;
        }
        while (stackAndDFS.size() != 0) {
            TreeNode tmp = stackAndDFS.pop();
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
        TreeNode tmp = stackAndDFS.pop();
        result.add(tmp.val);
        stackAndDFS.push(tmp.left);
        stackAndDFS.push(tmp.right);
        
        reverse(result);// 反转
```

### 4.层序
* <b>使用Queue队列，通过迭代iteration的方式,采用广度优先算法</b>

树的广度优先遍历的写法模式相对固定：
* 使用队列；
* 在队列非空的时候，动态取出队首元素；
* 取出队首元素的时候，把队首元素相邻的结点（非空）加入队列。
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
## 算法
二叉树用栈时使用深度优先算法，队列时使用广度优先算法，当二叉树是排序好的二叉搜索树时，可以使用二叉搜索算法。
树的DPS,WPS,可延伸为图的DPS,WPS
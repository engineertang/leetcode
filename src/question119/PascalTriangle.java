package question119;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/17.
 */
public class PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0)
            return list;
        //第n行有n+1个数，List.size=n+1
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            //自我更新list中index为1到 size-2的倒数第2个数，此处循环j是迭代的实现，每次会从一行一行往下迭代更新
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

}

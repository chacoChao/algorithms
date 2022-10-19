package com.chaco.chao.algorithms.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * amazon代码能力测试
 * +++++++++++++++++++++++第一题===========================================================
 * hackerrank.com/test/1b71ip6b6cq/questions/6m8
 * Chrome+CARS baidu ke didi sth Google
 * merge a lighter package with a heavier package, which eliminates the need for separate shipments.
 * More formally, consider n packages, where packageWeights[] represents the weight of the ith package. You can combine the th and (i+1)th package if packageWeights[i]< packageWeights[i+1], then discard the th package. After this operation, the number of packages is reduced by 1 and the weight of the (i+1)th package increases by packageWeights[I].
 * You can merge the packages any number of times.
 * Find the maximum possible weight of a package that can be achieved after any sequence of merge-operations.
 * Example
 * For example, packages are described as package_weights = [2,
 * 9, 10, 3, 7].
 * The optimal order of operations is, using 1-based indexing:
 * .
 * Combine the packages at index 2 and index 3, the new array of package weights becomes [2, 19, 3, 7].
 * • Combine the packages at index 1 and index 2, the new array of package weights becomes [21,3, 77.
 * • Combine the packages at index 2 and index 3, the new array of package weights becomes [21, 10].
 * We can not combine the packages anymore.
 * The weight of the heaviest package achievable after merging is
 * 21.
 * Function Description
 * Complete the function getHeaviestPackage in the editor below.
 * getHeaviestPackage has the following paramete
 *
 * 译文：
 * hackerrank.com/test/1b71ip6b6cq/questions/6m8
 * Chrome+CARS
 * 将较轻的包裹与较重的包裹合并，这样就不需要分开装运了。
 * 更正式地说，考虑n个包，其中packageWeights[]表示第i个包的权重。如果packageWeights[i]< packageWeights[i+1]，可以合并第th和(i+1)个包，然后丢弃第th个包。执行该操作后，包的数量减少1，第(i+1)个包的权重增加packageWeights[i]。
 * 您可以任意多次合并这些包。
 * 找到在任何合并操作序列之后可以实现的包的最大可能权重。
 * 例子
 * 例如，包被描述为package_weights = [2，
 * 9,10,3,7]。
 * 使用基于1的索引，操作的最佳顺序为:
 * ．
 * 将索引2和索引3处的包合并，新的包权重数组为[2,19,3,7]。
 * •将索引1和索引2的包合并，新的包权重数组变成[21,3,77]。
 * •将索引2和索引3的包合并，新的包权重数组变为[21,10]。
 * 我们不能再合并这些包了。
 * 合并后可达到的最重包的重量为
 * 21.
 * 功能描述
 * 在下面的编辑器中完成getHeaviestPackage函数。
 * getHeaviestPackage有以下参数
 *
 *
 * ==================================================================================================
 * +++++++++++++++++++++++第二题===========================================================
 * 亚马逊仓库有一组n个不同权重的商品
 * 排成
 * 一排
 * 一段连续放置的项可以
 * 一起发货时，
 * 只有当差异
 * 最重的物品和最轻的物品的重量相差最多
 * 避免负载不平衡。
 * 所有人,
 * 给定n个元素的权重和一个整数k，求
 * 可以一起装运的物品分段数。
 * 注意：段(1，r)是一个从索引/和开始的子数组
 * 在lsr所在的索引r处结束。
 * 例子
 * K=3
 * 权重=「1,3,6]
 * 每个(,八指标最大值和最小值之间的权重差
 * 两人：
 * (0,0)-＞max (重量101)-min(重量101)=max(1)一一外祖母(1)=1
 * 1=0
 * (0,1)-> max(1,3)- min(1,3) =3-1=2
 * ，(0.2)->max(1、3、6)-min(1、3、 6=6-1=5** *差异>k
 * (1,1)>max(3) - min(3) = 3-3=0
 * • (1,2) #max(3,6) - min (3,6) =6-3=3
 * (2,2) #max(6) - min(6) = 6-6=0
 *
 * 个可能的片段中有5个的差值小于或等于3。返回5。
 * 功能描述
 * 在下面的编辑器中完成函数countpossiblessegmentso
 * countpossiblessegments有如下参数:int k:最大
 * 允许的权重差。int weights[n]：条目的权重
 * 返回
 * 看漫画记6000词 发货的项自段数
 */
public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(20);
        list.add(13);
        list.add(8);
        list.add(9);
        long heaviestPackage = Test1.getHeaviestPackage(list);
        System.out.println(heaviestPackage);
    }

    public static long getHeaviestPackage(List<Integer> packageWeights) {
        // Write your code here
        if (null == packageWeights || packageWeights.size() == 0) {
            return 0l;
        }
        int length = packageWeights.size();
        Long maxVal = 0l;
        boolean isEnter = false;
        List<Integer> tmpList = new ArrayList<>(length);
        for (int i = 0; i < length - 1; i++) {
            int j = i;
            while (j < length - 1) {
                tmpList.add(packageWeights.get(j));
                if (packageWeights.get(j) < packageWeights.get(j + 1)) {
                    isEnter = true;
                    tmpList.add(packageWeights.get(j) + packageWeights.get(j + 1));
                }
                j++;
            }
        }
        if (!isEnter) {
            return maxVal;
        }
        maxVal = Math.max(maxVal, getHeaviestPackage(tmpList));
        Integer tmpMaxVal = tmpList.stream().max(Comparator.comparing(x -> x)).orElse(null);
        return maxVal > tmpMaxVal ? maxVal : tmpMaxVal;
    }
}

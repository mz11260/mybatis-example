package com.mz;

import com.mz.entity.OrderItem;
import com.mz.entity.OrderMode;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime) // 测试方法平均执行时间
@OutputTimeUnit(TimeUnit.MICROSECONDS) // 输出结果的时间粒度为微秒
@State(Scope.Thread) // 每个测试线程一个实例
public class BeanCopyTest {

    private OrderMode model = new OrderMode();
    private BeanCopier beanCopier = BeanCopier.create(OrderMode.class, OrderItem.class, false);

    /**
     * 人工setter复制属性
     *
     */
    @Benchmark
    public OrderItem manualSetter() {
        OrderItem vo = new OrderItem();
        vo.setId(model.getId());
        vo.setCreateTime(model.getCreateTime());
        vo.setDetail(model.getDetail());
        vo.setName(model.getName());
        vo.setPic(model.getPic());
        vo.setPrice(model.getPrice());
        return vo;
    }

    @Benchmark
    public String testToString() {
        return ToStringBuilder.reflectionToString(model);
    }

    @Benchmark
    public String testToString2() {
        return model.toString();
    }

    @Benchmark
    public OrderItem springBeanUitls() {
        OrderItem vo = new OrderItem();
        BeanUtils.copyProperties(this.model, vo);
        return vo;
    }

    @Benchmark
    public OrderItem springBeanCopier() {
        OrderItem vo = new OrderItem();
        beanCopier.copy(this.model, vo, null);
        return vo;
    }

    @Benchmark
    public OrderItem commonsBeanUtils() throws InvocationTargetException, IllegalAccessException {
        OrderItem vo = new OrderItem();
        org.apache.commons.beanutils.BeanUtils.copyProperties(this.model, vo);
        return vo;
    }

    @Benchmark
    public OrderItem commonsPropertiesUtils() throws Exception {
        OrderItem vo = new OrderItem();
        PropertyUtils.copyProperties(this.model, vo);
        return vo;
    }

    public static void main(String[] args) throws RunnerException {
        // 使用一个单独进程执行测试，执行5遍warmup，然后执行5遍测试
        Options opt = new OptionsBuilder().include(BeanCopyTest.class.getSimpleName()).forks(1).warmupIterations(10)
                .measurementIterations(30).build();
        new Runner(opt).run();
    }

}

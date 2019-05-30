package cn.huangxulin.utils;

/**
 * 功能描述: 数据库表主键 id 生成器
 *
 * @author hxulin
 */
public enum IdWorker {

    INSTANCE;

    // 机房编号
    private long datacenterId;

    // 机器编号
    private long workerId;

    // 时间起始标记点(2019-04-18 10:45:55.555)
    private static final long EPOCH = 1555555555555L;

    // 机房标识位数
    private static final long DATACENTER_ID_BITS = 5L;

    // 机器标识位数
    private static final long WORKER_ID_BITS = 5L;

    /*
     * 毫秒内自增位数
     * 记录同一个毫秒内产生的不同 id
     * 12bit 代表的数字来区分同一个毫秒内的 4096 个不同的 id
     */
    private static final long SEQUENCE_BITS = 12L;

    // 机房标识位数占用 5bit, 最大机房ID为31, 最小为0
    private static final long MAX_DATACENTER_ID = -1L ^ (-1L << DATACENTER_ID_BITS);

    // 机器标识位数占用 5bit, 最大机器ID为31, 最小为0
    private static final long MAX_WORKER_ID = -1L ^ (-1L << WORKER_ID_BITS);

    public void setDatacenterId(long datacenterId) {
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException(
                    String.format("datacenter Id can't be greater than %d or less than 0", MAX_DATACENTER_ID));
        }
        this.datacenterId = datacenterId;
    }

    public void setWorkerId(long workerId) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
        this.workerId = workerId;
    }

    // 机器编号左移位数: 12, 左移将机器编号放到指定的 5bit 位置上
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;

    // 机房编号左移位数: 17, 左移将机房编号放到指定的 5bit 位置上
    private static final long DATACENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;

    // 时间戳左移位数: 22, 左移将时间戳放到指定的 41bit 位置上
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;

    // 毫秒内自增最大值: 4095(12位)
    private static final long SEQUENCE_MASK = -1L ^ (-1L << SEQUENCE_BITS);

    // 同一时间戳并发初始值
    private long sequence = 0;

    // 记录一下最近一次生成 id 的时间戳
    private long lastTimestamp = -1L;

    public static synchronized long nextId() {

        long timestamp = INSTANCE.timeGen();

        if (timestamp < INSTANCE.lastTimestamp) {
            System.err.printf("clock is moving backwards. Rejecting requests until %d.", INSTANCE.lastTimestamp);
            throw new RuntimeException(String.format(
                    "Clock moved backwards. Refusing to generate id for %d milliseconds.", INSTANCE.lastTimestamp - timestamp));
        }

        if (INSTANCE.lastTimestamp == timestamp) {
            // 一毫秒内最多产生 4096 个 id
            // 此处位运算保证时间戳的初始值始终在 4096 范围内，避免传入的 sequence 超过毫秒自增的最大值
            INSTANCE.sequence = (INSTANCE.sequence + 1) & SEQUENCE_MASK;
            if (INSTANCE.sequence == 0) {
                timestamp = INSTANCE.tilNextMillis(INSTANCE.lastTimestamp);
            }
        } else {
            INSTANCE.sequence = 0;
        }

        INSTANCE.lastTimestamp = timestamp;

        /*
         * 将时间戳左移, 放到指定的 41bit 的位置上
         * 将机房 id 左移, 放到指定的 5bit 的位置上
         * 将机器 id 左移, 放到指定的 5bit 的位置上
         * 将序号放在最后 12bit 的位置上
         * 最后拼接成一个 64bit 的二进制数字, 转换成 10 进制的 long 类型
         */
        return ((timestamp - EPOCH) << TIMESTAMP_LEFT_SHIFT) | (INSTANCE.datacenterId << DATACENTER_ID_SHIFT)
                | (INSTANCE.workerId << WORKER_ID_SHIFT) | INSTANCE.sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    public long getDatacenterId() {
        return datacenterId;
    }

    public long getWorkerId() {
        return workerId;
    }

}

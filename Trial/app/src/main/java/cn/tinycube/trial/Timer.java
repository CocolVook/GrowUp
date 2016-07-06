package cn.tinycube.trial;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/**
 * @author: WangJianbiao
 * @time: 16/4/25-下午5:58.
 * @email: 617882976@qq.com
 * <p/>
 * 计时器 支持正向计时，逆向计时
 * <p/>
 * 使用请看
 * {@link Timer.Callback#onTick(long, long)}
 */
public class Timer {

    public enum State {
        CREATE,
        RUNNING,
        PAUSED,
        STOP
    }

    public static final int MSG = 1;

    private Callback callback;
    /**
     * 最大值可取{@link Long#MAX_VALUE}
     */
    private final long mTotalTime;

    /**
     * 上一个计时时间点
     */
    private long mLastTimePoint;

    /**
     * 度过的时间
     */
    private long mSpendTime;

    /**
     * 增量、tick
     */
    private final long mTick;

    /**
     * 计时器所处的状态
     */
    private State mState = State.CREATE;

    interface Callback {
        void onFinish();

        /**
         * @param millisSpend 度过毫秒值(过去的毫秒值)
         * @param millisLeft  剩下毫秒值(剩下的毫秒值)
         */
        void onTick(long millisSpend, long millisLeft);
    }

    private Timer(long millisTick, long totalMillis, Callback callback) {
        this.callback = callback;
        mTotalTime = totalMillis;
        mTick = millisTick;
    }

    public synchronized final void stop() {
        mState = State.CREATE;
        mHandler.removeMessages(MSG);
        mSpendTime = 0;
    }

    public synchronized final void pause() {
        mState = State.PAUSED;
        mHandler.removeMessages(MSG);
    }


    public synchronized final Timer start() {
        if (mTotalTime <= 0) {
            callback.onFinish();
            return this;
        }
        mState = State.RUNNING;
        mLastTimePoint = SystemClock.elapsedRealtime();
        mHandler.sendMessage(mHandler.obtainMessage(MSG));
        return this;
    }

    @SuppressWarnings("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            synchronized (this) {
                if (mState == State.RUNNING) {
                    final long now = SystemClock.elapsedRealtime();
                    final long tinySpendTime = now - mLastTimePoint;
                    mSpendTime += tinySpendTime;
                    mLastTimePoint = now;
                    long leftTime = mTotalTime - mSpendTime;
                    if (isFinish()) {
                        mState = State.CREATE;
                        callback.onFinish();
                        mSpendTime = 0;
                    } else if (leftTime < mTick / 2) {
                        sendMessageDelayed(obtainMessage(MSG), leftTime);
                    } else {
                        callback.onTick(mSpendTime, leftTime);
                        sendMessageDelayed(obtainMessage(MSG), getNextDelta(now));
                    }
                }
            }
        }

        private boolean isFinish() {
            return mSpendTime >= mTotalTime;
        }

        private long getNextDelta(long prev) {
            final long now = SystemClock.elapsedRealtime();
            long delta = prev + mTick - now;
            while (delta < mTick / 2) delta += mTick;
            return delta;
        }
    };

    public static class Builder {
        private long mInterval;
        private long mTotalTime;
        private Callback mCallback;

        public Builder(Callback callback) {
            mInterval = 1000;
            mTotalTime = Long.MAX_VALUE;
            mCallback = callback;
        }

        /**
         * 设置多长时间回调一次
         */
        public Builder setInterval(long interval) {
            mInterval = interval;
            return this;
        }

        /**
         * 设置总共的计时时长毫秒值
         */
        public Builder setTotalMillis(long totalMillis) {
            mTotalTime = totalMillis;
            return this;
        }

        /**
         * 设置总共的计时时长秒数
         */
        public Builder setTotalSeconds(long totalSeconds) {
            mTotalTime = totalSeconds * 1000;
            return this;
        }

        public Timer builder() {
            return new Timer(mInterval, mTotalTime, mCallback);
        }
    }

}

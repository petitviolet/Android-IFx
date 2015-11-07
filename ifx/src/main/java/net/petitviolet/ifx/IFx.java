package net.petitviolet.ifx;

import net.petitviolet.ifx.func.Action;

/**
 * A result = IFx.of(condition).then(x)//.get()
 * .elseIf(condition2).then(y)//.get()
 * .else(z)
 * @param <A>
 */
public class IFx<A> {
    private static final String TAG = IFx.class.getSimpleName();
    private boolean mIsTrue;
    private boolean mIsDefined = false;
    private A mValue;

    @Override
    public String toString() {
        return "IFx{" +
                "mIsTrue=" + mIsTrue +
                ", mIsDefined=" + mIsDefined +
                ", mValue=" + mValue +
                '}';
    }

    private IFx(boolean isTrue) {
        mIsTrue = isTrue;
    }

    public static <A> IFx<A> of(boolean isTrue) {
        return new IFx<>(isTrue);
    }

    public IFx<A> then(A result) {
        if (!mIsDefined && mIsTrue) {
            mValue = result;
            mIsDefined = true;
        }
        return this;
    }

    public IFx<A> then(Action<A> result) {
        if (!mIsDefined && mIsTrue) {
            mValue = result.run();
            mIsDefined = true;
        }
        return this;
    }

    public A get() {
        return mIsDefined && mIsTrue ? mValue : null;
    }

    public IFx<A> ElseIf(Boolean isTrue) {
        if (!mIsDefined) {
            mIsTrue = isTrue;
            System.out.println("YES");
        }
        return this;
    }

    public A Else(A result) {
        return mIsDefined ? mValue : result;
    }
    public A Else(Action<A> result) {
        return mIsDefined ? mValue : result.run();
    }
}

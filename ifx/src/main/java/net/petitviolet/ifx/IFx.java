package net.petitviolet.ifx;

/**
 * A result = IFx.of(condition).apply(x)//.get()
 * .elseIf(condition2).apply(y)//.get()
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

    public IFx<A> apply(A result) {
        if (!mIsDefined && mIsTrue) {
            mValue = result;
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
}

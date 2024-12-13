package practice.test;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.comcast.crm.basetest.BaseClass;

public class ITestListenerrrrr1 extends BaseClass implements ITestListener,ISuiteListener  {

	@Override
	public void onStart(ISuite suite) {
		ISuiteListener.super.onStart(suite);
		System.out.println("onStart");
	}

	@Override
	public void onFinish(ISuite suite) {
		ISuiteListener.super.onFinish(suite);
		System.out.println("onFinish");
	}

	@Override
	public boolean isEnabled() {
		return ITestListener.super.isEnabled();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		System.out.println("onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		System.out.println("onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		System.out.println("onTestFailure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		System.out.println("onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
		System.out.println("onStartTest");
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
		System.out.println("onFinishTest");
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize");
	}
	

}

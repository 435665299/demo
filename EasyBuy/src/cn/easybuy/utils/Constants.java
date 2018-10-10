package cn.easybuy.utils;

public class Constants {
	/**
	 * json 格式 返回数据的status 标示说明
	 */
	public static interface ReturnResult {
		public static int SUCCESS = 1;
		public static int FAIL = -1;
	}

	/**
	 * 前后台用户
	 */
	public static interface UserType {
		public static int pre = 1; //普通用户
		public static int BACKEND = 2; //管理员
	}

}

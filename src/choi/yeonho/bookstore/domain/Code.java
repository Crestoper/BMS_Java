package choi.yeonho.bookstore.domain;

public interface Code {
	/*
	 프로그램명 : BMS(서점관리자 시스템)
	 작성일     : 3.27 - 3.31
	 작성자     : 최연호
	 페이지 설명 :	기능정의서 코드 모음 
	 */

	//기능정의서 코드
	//서점(999)
		//관리자(1)
			//재고관리(1-1)
				//도서목록조회(1-1-1)
				//도서등록(1-1-2)
				//도서수정(1-1-3)
				//도서삭제(1-1-4)
				//이전(1-1)
			//주문관리(1-2)
				//주문목록(1-2-1)
				//결재승인(1-2-2)
				//결재취소(1-2-3)
			//결산(1-2-4)
			
		//구매자(2)
			//도서목록
	
	public final static int SHOP_LOGIN = 999;
	public final static int HOST = 1;
	public final static int HOST_BOOK = 11;
	public final static int HOST_BOOK_LIST = 111;
	public final static int HOST_BOOK_ADD = 112;
	public final static int HOST_BOOK_UPDATE = 113;
	public final static int HOST_BOOK_INSERT = 114;
	public final static int HOST_BOOK_DEL = 115;
	public final static int HOST_BOOK_BACK = 116;//이전
	public final static int HOST_ORDER = 12;
	public final static int HOST_ORDER_LIST = 121;
	public final static int HOST_ORDER_CONFIRM = 122;
	public final static int HOST_ORDER_CANCLE = 123; 
	public final static int HOST_SALE_TOTAL = 124;
	public final static int GUEST = 2;
	public final static int GUEST_SHOPPING = 21;
	public final static int GUEST_CART = 211;
	public final static int GUEST_CART_FOLD = 2111;
	public final static int GUEST_CART_REFUND = 2112;
	public final static int GUEST_CART_BUY = 2113;
	public final static int GUEST_BUY = 212;
	public final static int GUEST_REFUND = 213;
	public final static int GUEST_INFO_CHANGE = 214;
	public static final int DELIVERY_STATE = 215;
	
	public final static int ORDERCONFIRM_IMPOSSIBLE = 0; //관리자 OrderConFirm에 조회 가능 여부 : 구매가자 구매를 하였는가?
	public final static int ORDERCONFIRM_POSSIBLE = 1;	 //관리자 OrderConFirm에 조회 가능 여부 :  구매가자 구매를 하였는가?
	
	public final static int ORDERCANCLE_IMPOSSIBLE = 0;	//구매자 환불 신청 여부 0 = 안함
	public final static int ORDERCANCLE_POSSIBLE = 1;	//구매자 환불 신청 여부 1 = 함
	
	public final static String ORDERCANCLE_STATE_NOMAL = "N"; 
	public final static String ORDERCANCLE_STATE_CALLING = "Y";
	
	public final static int DELIVERY_STATE_READY = 0;
	public final static int DELIVERY_STATE_GO = 1;
	public final static int DELIVERY_STATE_DONE = 2;
	
}

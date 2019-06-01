package project_ui;

import Customer_util.CMUtility;
import project_bean.Customer;
import project_service.CustomerList;

public class CustomerView {
	private CustomerList customerList = new CustomerList(10);
	
	public CustomerView() {
		Customer customer = new Customer("����",'��',38,"5858694","abc@gmail.com");
		customerList.addCustomer(customer);
	}
	public void enterMainMenu() {
		
		boolean isFlag = true;
		while(isFlag) {
			System.out
	        .println("\n--------------�ͻ���Ϣ�������--------------");
	System.out.println("                1����û�");
	System.out.println("                2�޸Ŀͻ�");
	System.out.println("                3ɾ���ͻ�");
	System.out.println("                4�ͻ��б�");
	System.out.println("                5��   ��\n");
	System.out.print("                ��ѡ��(1-5).");
	
	char menu = CMUtility.readMenuSelection();
	switch (menu) {
	case '1':
		addNewCustomer();
		break;
	case '2':
		modifyCustomer();
		break;
	case '3':
		deleteCustomer();
		break;
	case '4':
		listAllCustomer();
		break;
	case '5':
		System.out.println("�˳�");
		
		System.out.print("ȷ���Ƿ��˳�(Y/N):");
		char isExit =  CMUtility.readConfirmSelection();
		if (isExit =='Y') {
			isFlag = false;
		}
		break;
	
	}
	
		}
		
		
	}
	
	private void addNewCustomer() {
		System.out.println("---------------------��ӿͻ�--------------------\n");
		System.out.print("������");
		String name = CMUtility.readString(10);
		System.out.print("�Ա�:");
		char gender = CMUtility.readChar();
		System.out.print("����:");
		int age = CMUtility.readInt();
		System.out.print("�绰:");
		String phone = CMUtility.readString(13);
		System.out.print("����:");
		String email = CMUtility.readString(30);
		
		Customer customer = new Customer(name, gender, age, phone, email);
		
		boolean isSuccess = customerList.addCustomer(customer);
		if (isSuccess) {
			System.out.println("---------------------������--------------------\n");
		}else {
			System.out.println("---------------�ͻ�Ŀ¼���������ʧ��--------------\n");
		}
		
	}
	
	private void modifyCustomer() {
		System.out.println("---------------------�޸Ŀͻ�--------------------\n");
		Customer cust;
		int number;
		for(;;){
		System.out.print("��ѡ����޸Ŀͻ����(-1�˳�).");
		number = CMUtility.readInt();
		if (number==-1) {
			return;
			}
	 	cust = customerList.getCustomer(number-1);
	 	if (cust == null) {
			System.out.println("�޷�ʶ��ָ���ͻ���");
		}else {
			break;
		}
		
		}
		System.out.print("������"+cust.getName()+"):");
		String name = CMUtility.readString(10, cust.getName());
		System.out.print("�Ա�"+cust.getGender()+"):");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.print("���䣨"+cust.getAge()+"):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.print("�绰��"+cust.getPhone()+"):");
		String phone = CMUtility.readString(13, cust.getPhone());
		System.out.print("���䣨"+cust.getEmail()+"):");
		String email =  CMUtility.readString(30, cust.getEmail());
		
		Customer newCust = new Customer(name, gender, age, phone, email);
		
		boolean isReplaced  = customerList.replaceCustomer(number-1, newCust);
		if (isReplaced) {
			System.out.println("---------------------�޸����--------------------\n");
		}else {
			System.out.println("---------------------�޸�ʧ��--------------------\n");
		}
	}
	
	private void deleteCustomer() {
		System.out.println("---------------------ɾ���ͻ�--------------------\n");
		int number;
		for(;;) {
			System.out.print("��ѡ���ɾ���ͻ���ţ�-1�˳���.");
		 	number = CMUtility.readInt();
		 	
		 	if (number == -1) {
				return;
			}
		 	
		 	Customer customer = customerList.getCustomer(number-1);
		 	if (customer == null) {
				System.out.println("�޷��ҵ�ָ����Ϣ!");
			}else  {
				break;
			}
		}
		
		System.out.println("ȷ���Ƿ�ɾ��(Y/N).");
		char isDelete = CMUtility.readConfirmSelection();
		if (isDelete=='Y') {
			boolean deleteSuccess = customerList.deleteCustomer(number-1);
			if (deleteSuccess) {
				System.out.println("---------------------ɾ�����--------------------\n");
			}else {
				System.out.println("---------------------ɾ��ʧ��--------------------\n");
			}
		}else {
			return;
		}
	}
	
	private void listAllCustomer() {
		System.out.println("---------------------�ͻ��б�--------------------\n");
		
		int total = customerList.getTotal();
		if (total==0) {
			System.out.println("û�пͻ���¼");
			
		}else {
			System.out.println("���\t����\t�Ա�\t����\t�绰\t����");
			Customer[] custs = customerList.getAllCustomer();
			for(int i=0;i<custs.length;i++) {
				Customer cust = custs[i];
				System.out.println((i+1)+"\t"+cust.getName()+"\t"+cust.getGender()+"\t"
				+cust.getAge()+"\t"+cust.getPhone()+"\t"+cust.getEmail());
			}
		}
		
		
		System.out.println("-------------------�ͻ��б����------------------\n");
		
	}
	
	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
	}
}

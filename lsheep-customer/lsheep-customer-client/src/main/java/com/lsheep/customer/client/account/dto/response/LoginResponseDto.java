package com.lsheep.customer.client.account.dto.response;

public class LoginResponseDto {

	private boolean success;
	private CustomerDto customerDto;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

}

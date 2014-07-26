package net.kuwalab.jsr349;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Book {
	@NotNull
	@Length(min = 10, max = 10)
	private String isbn;
	@NotNull
	@Length(min = 3, max = 30)
	private String name;
	@NotNull
	private Integer price;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public static void main(String... args) {
		ValidatorFactory validatorFactory = Validation
				.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Book book = new Book();
		book.setIsbn("123456789ab");
		book.setName("1");
		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		for (ConstraintViolation<Book> violation : violations) {
			System.out.println(violation.getPropertyPath());
			System.out.println(violation.getMessage());
		}
	}
}

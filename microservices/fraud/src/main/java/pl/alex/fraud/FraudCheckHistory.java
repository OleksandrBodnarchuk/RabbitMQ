package pl.alex.fraud;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckHistory {

	@Id
	@SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
	private Integer id;
	private Integer customerId;
	private Boolean isFraudster;
	private LocalDateTime createdAt;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		FraudCheckHistory that = (FraudCheckHistory) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}

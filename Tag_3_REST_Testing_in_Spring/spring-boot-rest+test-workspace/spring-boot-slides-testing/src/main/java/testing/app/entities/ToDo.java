package testing.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {

	enum CompletionStage { OPEN, CLOSED, ONGOING };
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;
	
	private LocalDate deadline;
	private CompletionStage completionStatus;
	
	// changed tracking
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	public ToDo()
	{
		completionStatus = CompletionStage.OPEN;
		createdAt = LocalDateTime.now();
		modifiedAt = LocalDateTime.now();
	}
	
	public ToDo(String description)
	{
		this.description = description;
		
		this.completionStatus = CompletionStage.OPEN;
		this.createdAt = LocalDateTime.now();
		this.modifiedAt = LocalDateTime.now();
	}

	
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", description=" + description + ", deadline=" + deadline + ", completionStatus="
				+ completionStatus + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + "]";
	}

	
	
	// WICHTIG !!
	@Override
	public int hashCode() {
		return Objects.hash(deadline, description);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDo other = (ToDo) obj;
		return Objects.equals(deadline, other.deadline) && Objects.equals(description, other.description);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public CompletionStage getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(CompletionStage completionStatus) {
		this.completionStatus = completionStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	
	
}

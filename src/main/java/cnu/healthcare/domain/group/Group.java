package cnu.healthcare.domain.group;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "group_id", columnDefinition = "BINARY(16)")
    private UUID groupId;

    @Column(name = "group_name")
    private String groupName;

    public Group(String groupName) {
        this.groupName = groupName;
    }
}

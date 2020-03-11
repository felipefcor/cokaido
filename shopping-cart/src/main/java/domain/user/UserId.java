package domain.user;

import domain.memento.UserIdMemento;

import java.util.Objects;

public class UserId {
    private final int userId;

    public UserId(int userId) {
        this.userId = userId;
    }

    public UserIdMemento createMemento() {
        UserIdMemento userIdMemento = new UserIdMemento();
        userIdMemento.id = this.userId;
        return userIdMemento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId1 = (UserId) o;
        return userId == userId1.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String
    toString() {
        return Integer.toString(this.userId);
    }
}

package net.optm.model;

public class BettingSchedule extends Component {

    private String name;

    public BettingSchedule(final String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}

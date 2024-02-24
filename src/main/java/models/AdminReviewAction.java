package models;

import lombok.Data;

@Data
public class AdminReviewAction {
    private boolean accept;

    public AdminReviewAction(boolean accept) {this.accept = accept;}
}

package ideadline.ideadline;

/**
 * Created by Craigg on 20/03/2016.
 */
public class ToDoItem {

    /**
     * Item text
     */
    @com.google.gson.annotations.SerializedName("text")
    private String mText;

    /**
     * Item Id
     */
    @com.google.gson.annotations.SerializedName("description")
    private String mDescription;


    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    /**
     * Indicates if the item is completed
     */
    @com.google.gson.annotations.SerializedName("complete")
    private boolean mComplete;

    /**
     * ToDoItem constructor
     */
    public ToDoItem() {

    }

    @Override
    public String toString() {
        return getText();
    }

    /**
     * Initializes a new ToDoItem
     *
     * @param text
     *            The item text
     * @param id
     *            The item id
     *  @param description
     */
    public ToDoItem(String text, String id, String description ) {
        this.setText(text);
        this.setId(id);
        this.setDescription(description);
    }

    /**
     * Returns the item text
     */
    public String getText() {
        return mText;
    }

    /**
     * Sets the item text
     *
     * @param text
     *            text to set
     */
    public final void setText(String text) {
        mText = text;
    }

    /**
     * Returns the item id
     */
    public String getId() {
        return mId;
    }

    /**
     * Sets the item id
     *
     * @param id
     *            id to set
     */
    public final void setId(String id) {
        mId = id;
    }

    /**
     * Indicates if the item is marked as completed
     */
    public boolean isComplete() {
        return mComplete;
    }

    /**
     * Marks the item as completed or incompleted
     */
    public void setComplete(boolean complete) {
        mComplete = complete;
    }

    public String getDescription() {
        return mDescription;
    }

    /**
     * Sets the item text
     *
     * @param description
     *            text to set
     */
    public final void setDescription (String description) {
        mDescription = description;
    }

    /**
     * Returns the item id
     */

    @Override
    public boolean equals(Object o) {
        return o instanceof ToDoItem && ((ToDoItem) o).mId == mId;
    }
}
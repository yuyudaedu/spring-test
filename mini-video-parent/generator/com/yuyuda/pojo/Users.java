package com.yuyuda.pojo;

public class Users {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.face_image
     *
     * @mbg.generated
     */
    private String faceImage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.nickname
     *
     * @mbg.generated
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.fans_counts
     *
     * @mbg.generated
     */
    private Integer fansCounts;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.follow_counts
     *
     * @mbg.generated
     */
    private Integer followCounts;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.receive_like_counts
     *
     * @mbg.generated
     */
    private Integer receiveLikeCounts;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.id
     *
     * @return the value of users.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.id
     *
     * @param id the value for users.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.username
     *
     * @return the value of users.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.username
     *
     * @param username the value for users.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.password
     *
     * @return the value of users.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.password
     *
     * @param password the value for users.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.face_image
     *
     * @return the value of users.face_image
     *
     * @mbg.generated
     */
    public String getFaceImage() {
        return faceImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.face_image
     *
     * @param faceImage the value for users.face_image
     *
     * @mbg.generated
     */
    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage == null ? null : faceImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.nickname
     *
     * @return the value of users.nickname
     *
     * @mbg.generated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.nickname
     *
     * @param nickname the value for users.nickname
     *
     * @mbg.generated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.fans_counts
     *
     * @return the value of users.fans_counts
     *
     * @mbg.generated
     */
    public Integer getFansCounts() {
        return fansCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.fans_counts
     *
     * @param fansCounts the value for users.fans_counts
     *
     * @mbg.generated
     */
    public void setFansCounts(Integer fansCounts) {
        this.fansCounts = fansCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.follow_counts
     *
     * @return the value of users.follow_counts
     *
     * @mbg.generated
     */
    public Integer getFollowCounts() {
        return followCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.follow_counts
     *
     * @param followCounts the value for users.follow_counts
     *
     * @mbg.generated
     */
    public void setFollowCounts(Integer followCounts) {
        this.followCounts = followCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.receive_like_counts
     *
     * @return the value of users.receive_like_counts
     *
     * @mbg.generated
     */
    public Integer getReceiveLikeCounts() {
        return receiveLikeCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.receive_like_counts
     *
     * @param receiveLikeCounts the value for users.receive_like_counts
     *
     * @mbg.generated
     */
    public void setReceiveLikeCounts(Integer receiveLikeCounts) {
        this.receiveLikeCounts = receiveLikeCounts;
    }
}
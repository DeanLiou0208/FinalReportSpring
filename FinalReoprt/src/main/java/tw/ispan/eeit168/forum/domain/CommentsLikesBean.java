package tw.ispan.eeit168.forum.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;


@Entity
@Table(name = "comments_likes")
@IdClass(CommentsLikesBean.CommentLikeId.class)
public class CommentsLikesBean implements Serializable{
		
	    @Id
	    @Column(name = "fk_member_id")
	    private Integer fkMemberId;

	    @Id
	    @Column(name = "fk_comment_id")
	    private Integer fkCommentId;

	    @Column(name = "create_at", columnDefinition = "datetime")
		private Timestamp createAt;
		@Column(name = "like_or_unlike")
		private Boolean likeOrUnlike;
		
		@Override
		public String toString() {
			return "CommentsLikesBean [fkMemberId=" + fkMemberId + ", fkCommentId=" + fkCommentId + ", createAt="
					+ createAt + ", likeOrUnlike=" + likeOrUnlike + "]";
		}


		public Integer getFkMemberId() {
			return fkMemberId;
		}

		public void setFkMemberId(Integer fkMemberId) {
			this.fkMemberId = fkMemberId;
		}

		public Integer getFkCommentId() {
			return fkCommentId;
		}

		public void setFkCommentId(Integer fkCommentId) {
			this.fkCommentId = fkCommentId;
		}

		public Timestamp getCreateAt() {
			return createAt;
		}

		public void setCreateAt(Timestamp createAt) {
			this.createAt = createAt;
		}

		public Boolean getLikeOrUnlike() {
			return likeOrUnlike;
		}

		public void setLikeOrUnlike(Boolean likeOrUnlike) {
			this.likeOrUnlike = likeOrUnlike;
		}

		public static class CommentLikeId implements Serializable {
		    private Integer fkMemberId;
		    private Integer fkCommentId;
			public Integer getFkMemberId() {
				return fkMemberId;
			}
			public void setFkMemberId(Integer fkMemberId) {
				this.fkMemberId = fkMemberId;
			}
			public Integer getFkCommentId() {
				return fkCommentId;
			}
			public void setFkCommentId(Integer fkCommentId) {
				this.fkCommentId = fkCommentId;
			}
			@Override
			public int hashCode() {
				return Objects.hash(fkCommentId, fkMemberId);
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				CommentLikeId other = (CommentLikeId) obj;
				return Objects.equals(fkCommentId, other.fkCommentId) && Objects.equals(fkMemberId, other.fkMemberId);
			}
			
			
		    
	
//	@EmbeddedId
//    private CommentLikeId id;
//
//	@Column(name = "create_at", columnDefinition = "datetime")
//	private Timestamp createAt;
//	@Column(name = "like_or_unlike")
//	private Boolean likeOrUnlike;
//
//	@Override
//	public String toString() {
//		return "CommentsLikesBean [id=" + id + ", createAt=" + createAt + ", likeOrUnlike=" + likeOrUnlike + "]";
//	}
//
//	public CommentLikeId getId() {
//		return id;
//	}
//
//	public void setId(CommentLikeId id) {
//		this.id = id;
//	}
//
//	public Timestamp getCreateAt() {
//		return createAt;
//	}
//
//	public void setCreateAt(Timestamp createAt) {
//		this.createAt = createAt;
//	}
//
//	public Boolean isLikeOrUnlike() {
//		return likeOrUnlike;
//	}
//
//	public void setLikeOrUnlike(Boolean likeOrUnlike) {
//		this.likeOrUnlike = likeOrUnlike;
//	}
//
//
//
//
//	@Embeddable
//	class CommentLikeId implements Serializable {
//
//	    @Column(name = "fk_member_id")
//	    private Integer fkMemberId;
//
//	    @Column(name = "fk_comment_id")
//	    private Integer fkCommentId;
//
//		public Integer getFkMemberId() {
//			return fkMemberId;
//		}
//
//		public void setFkMemberId(Integer fkMemberId) {
//			this.fkMemberId = fkMemberId;
//		}
//
//		public Integer getFkCommentId() {
//			return fkCommentId;
//		}
//
//		public void setFkCommentId(Integer fkCommentId) {
//			this.fkCommentId = fkCommentId;
//		}
//
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + getEnclosingInstance().hashCode();
//			result = prime * result + Objects.hash(fkCommentId, fkMemberId);
//			return result;
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			CommentLikeId other = (CommentLikeId) obj;
//			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
//				return false;
//			return fkCommentId == other.fkCommentId && fkMemberId == other.fkMemberId;
//		}
//
//		private CommentsLikesBean getEnclosingInstance() {
//			return CommentsLikesBean.this;
//		}
	    
	    
	
	}
	
}

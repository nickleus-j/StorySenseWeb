/*******************************************************************************
 *Copyright (c) 2013 IBM Corporation and others.
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    IBM Corporation - initial API and implementation
 *******************************************************************************/
package dao;

import entity.Rating;
import java.util.List;
public abstract class RatingDAO {

	public abstract List<Rating> getRatings();
	public abstract List<Rating> getRatingsOfReader(int readerID);
	public abstract List<Rating> getRatingsOfReaderToWriter(int readerID,int writerID);
	public abstract List<Rating> getRatingsOfWriter(int WriterID);
	public abstract Rating getRatingsOfReader(int readerID,int accomID);
	public abstract List<Rating> getRatingsOfAccomplishment(int accomID);
	public abstract List<Rating> getRatingsOfStoriesWithLevel(int level,int readerID);
	public abstract List<Rating> getRatingsOfStoriesWithMinLevel(int level,int readerID);
	public abstract int getTotalScore(int accomID);
	public abstract void addRating(Rating r);
	public abstract void updateRating(Rating r);
	public abstract int getMaximumScore(int userID);
	public abstract int getMinimumScore(int userID);
}

/*
 * Copyright (C) 2003-2010 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.faq.service;

public interface AnswerEventLifeCycle {

  public void saveQuestion(Question question, boolean isNew);

  public void saveAnswer(String questionId, Answer answer, boolean isNew);

  public void saveAnswer(String questionId, Answer[] answers, boolean isNew);

  public void saveComment(String questionId, Comment comment, String language);
  
  public void voteQuestion(String questionId);
  
  public void unVoteQuestion(String questionId);
  
  public void removeQuestion(String questionActivityId);
  
  public void removeAnswer(String questionId, String answerActivityId);
  
  public void removeComment(String questionActivityId, String commentActivityId, String questionPath);
  
}

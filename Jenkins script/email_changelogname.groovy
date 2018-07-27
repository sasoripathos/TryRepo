/**
 * This module is a Pre-send Script for Editable Email Notification.
 * When a Jenkins build is configured to attach Build Log, the build log is default named as build.log
 * this script can change the default name of log file into "${JOB_NAME} yyyy_MM_dd HH_mm_ss.log".
 */

import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import java.io.*;
import javax.mail.util.ByteArrayDataSource;
import java.util.Date;
import java.text.SimpleDateFormat;

/*get current date and time, generate new names*/
def formatter = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");  
def date = new Date();  
def title = "${JOB_NAME} " + formatter.format(date) + ".log";

// Get the body of the email
def mimeMultipart = (MimeMultipart) msg.getContent();
// Check every part of the email
def count = mimeMultipart.getCount();
// Find the bodyPart for attachment, whose MimeType is "text/plain" and is an instance of ByteArrayInputStream
for (int i = 0; i < count; i++) {
	def bodyPart = mimeMultipart.getBodyPart(i);
	def bodyContent = bodyPart.getContent();
	if (bodyPart.isMimeType("text/plain") && bodyContent instanceof ByteArrayInputStream) {
		// If find the attachment, change its file name
		bodyPart.setFileName(title);
    } 
}
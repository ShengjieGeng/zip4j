/*
 * Copyright 2010 Srikanth Reddy Lingala
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.lingala.zip4j.model;

import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;
import net.lingala.zip4j.zip.AesKeyStrength;
import net.lingala.zip4j.zip.CompressionLevel;
import net.lingala.zip4j.zip.CompressionMethod;
import net.lingala.zip4j.zip.EncryptionMethod;

import java.util.TimeZone;

public class ZipParameters {

  private CompressionMethod compressionMethod = CompressionMethod.DEFLATE;
  private CompressionLevel compressionLevel = CompressionLevel.NORMAL;
  private boolean encryptFiles = false;
  private EncryptionMethod encryptionMethod = EncryptionMethod.NONE;
  private boolean readHiddenFiles = true;
  private char[] password;
  private AesKeyStrength aesKeyStrength = AesKeyStrength.KEY_STRENGTH_256;
  private boolean includeRootFolder = true;
  private String rootFolderInZip;
  private TimeZone timeZone = TimeZone.getDefault();
  private int sourceFileCRC;
  private String defaultFolderPath;
  private String fileNameInZip;
  private boolean isSourceExternalStream;
  private int lastModifiedFileTime;

  public ZipParameters() {
  }

  public ZipParameters(ZipParameters zipParameters) {
    this.compressionMethod = zipParameters.getCompressionMethod();
    this.compressionLevel = zipParameters.getCompressionLevel();
    this.encryptFiles = zipParameters.isEncryptFiles();
    this.encryptionMethod = zipParameters.getEncryptionMethod();
    this.readHiddenFiles = zipParameters.isReadHiddenFiles();
    this.password = zipParameters.getPassword();
    this.aesKeyStrength = zipParameters.getAesKeyStrength();
    this.includeRootFolder = zipParameters.isIncludeRootFolder();
    this.rootFolderInZip = zipParameters.getRootFolderInZip();
    this.timeZone = zipParameters.getTimeZone();
    this.sourceFileCRC = zipParameters.getSourceFileCRC();
    this.defaultFolderPath = zipParameters.getDefaultFolderPath();
    this.fileNameInZip = zipParameters.getFileNameInZip();
    this.isSourceExternalStream = zipParameters.isSourceExternalStream();
    this.lastModifiedFileTime = zipParameters.getLastModifiedFileTime();
  }

  public CompressionMethod getCompressionMethod() {
    return compressionMethod;
  }

  public void setCompressionMethod(CompressionMethod compressionMethod) {
    this.compressionMethod = compressionMethod;
  }

  public boolean isEncryptFiles() {
    return encryptFiles;
  }

  public void setEncryptFiles(boolean encryptFiles) {
    this.encryptFiles = encryptFiles;
  }

  public EncryptionMethod getEncryptionMethod() {
    return encryptionMethod;
  }

  public void setEncryptionMethod(EncryptionMethod encryptionMethod) {
    this.encryptionMethod = encryptionMethod;
  }

  public CompressionLevel getCompressionLevel() {
    return compressionLevel;
  }

  public void setCompressionLevel(CompressionLevel compressionLevel) {
    this.compressionLevel = compressionLevel;
  }

  public boolean isReadHiddenFiles() {
    return readHiddenFiles;
  }

  public void setReadHiddenFiles(boolean readHiddenFiles) {
    this.readHiddenFiles = readHiddenFiles;
  }

  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  public char[] getPassword() {
    return password;
  }

  /**
   * Sets the password for the zip file or the file being added<br>
   * <b>Note</b>: For security reasons, usage of this method is discouraged. Use
   * setPassword(char[]) instead. As strings are immutable, they cannot be wiped
   * out from memory explicitly after usage. Therefore, usage of Strings to store
   * passwords is discouraged. More info here:
   * http://docs.oracle.com/javase/1.5.0/docs/guide/security/jce/JCERefGuide.html#PBEEx
   *
   * @param password
   */
  public void setPassword(String password) {
    if (password == null) return;
    setPassword(password.toCharArray());
  }

  public void setPassword(char[] password) {
    this.password = password;
  }

  public AesKeyStrength getAesKeyStrength() {
    return aesKeyStrength;
  }

  public void setAesKeyStrength(AesKeyStrength aesKeyStrength) {
    this.aesKeyStrength = aesKeyStrength;
  }

  public boolean isIncludeRootFolder() {
    return includeRootFolder;
  }

  public void setIncludeRootFolder(boolean includeRootFolder) {
    this.includeRootFolder = includeRootFolder;
  }

  public String getRootFolderInZip() {
    return rootFolderInZip;
  }

  public void setRootFolderInZip(String rootFolderInZip) {
    if (Zip4jUtil.isStringNotNullAndNotEmpty(rootFolderInZip)) {

      if (!rootFolderInZip.endsWith("\\") && !rootFolderInZip.endsWith("/")) {
        rootFolderInZip = rootFolderInZip + InternalZipConstants.FILE_SEPARATOR;
      }

      rootFolderInZip = rootFolderInZip.replaceAll("\\\\", "/");

//			if (rootFolderInZip.endsWith("/")) {
//				rootFolderInZip = rootFolderInZip.substring(0, rootFolderInZip.length() - 1);
//				rootFolderInZip = rootFolderInZip + "\\";
//			}
    }
    this.rootFolderInZip = rootFolderInZip;
  }

  public TimeZone getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(TimeZone timeZone) {
    this.timeZone = timeZone;
  }

  public int getSourceFileCRC() {
    return sourceFileCRC;
  }

  public void setSourceFileCRC(int sourceFileCRC) {
    this.sourceFileCRC = sourceFileCRC;
  }

  public String getDefaultFolderPath() {
    return defaultFolderPath;
  }

  public void setDefaultFolderPath(String defaultFolderPath) {
    this.defaultFolderPath = defaultFolderPath;
  }

  public String getFileNameInZip() {
    return fileNameInZip;
  }

  public void setFileNameInZip(String fileNameInZip) {
    this.fileNameInZip = fileNameInZip;
  }

  public boolean isSourceExternalStream() {
    return isSourceExternalStream;
  }

  public void setSourceExternalStream(boolean isSourceExternalStream) {
    this.isSourceExternalStream = isSourceExternalStream;
  }

  public int getLastModifiedFileTime() {
    return lastModifiedFileTime;
  }

  public void setLastModifiedFileTime(int lastModifiedFileTime) {
    this.lastModifiedFileTime = lastModifiedFileTime;
  }
}

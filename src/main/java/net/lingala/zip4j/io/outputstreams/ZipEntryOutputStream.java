package net.lingala.zip4j.io.outputstreams;

import java.io.IOException;
import java.io.OutputStream;

class ZipEntryOutputStream extends OutputStream {

  private long numberOfBytesWrittenForThisEntry = 0;
  private OutputStream outputStream;
  private boolean entryClosed;

  public ZipEntryOutputStream(OutputStream outputStream) {
    this.outputStream = outputStream;
    entryClosed = false;
  }

  @Override
  public void write(int b) throws IOException {
    write(new byte[] {(byte) b});
  }

  @Override
  public void write(byte[] b) throws IOException {
    write(b, 0, b.length);
  }

  @Override
  public void write(byte[] b, int off, int len) throws IOException {
    if (entryClosed) {
      throw new IllegalStateException("ZipEntryOutputStream is closed");
    }

    outputStream.write(b, off, len);
    numberOfBytesWrittenForThisEntry += len;
  }

  public void closeEntry() throws IOException {
    entryClosed = true;
  }

  public long getNumberOfBytesWrittenForThisEntry() {
    return numberOfBytesWrittenForThisEntry;
  }

  public void decrementBytesWrittenForThisEntry(int value) {
    if (value <= 0) return;

    if (value <= this.numberOfBytesWrittenForThisEntry) {
      this.numberOfBytesWrittenForThisEntry -= value;
    }
  }

  @Override
  public void close() throws IOException {
    outputStream.close();
  }
}
